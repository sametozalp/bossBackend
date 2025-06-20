package com.boss.bossBackend.security;

import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${boss.app.secret}")
    private String secret;

    private SecretKey key;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("role", user.getRole().name())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("type", "refresh")
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)))
                .signWith(key)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public User extractUser(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        String username = claims.getSubject();
        String roleStr = (String) claims.get("role");
        Role role = Role.valueOf(roleStr);

        User user = new User();
        user.setUsername(claims.getSubject());
        user.setRole(Role.valueOf((String) claims.get("role")));

        return user;
    }

}
