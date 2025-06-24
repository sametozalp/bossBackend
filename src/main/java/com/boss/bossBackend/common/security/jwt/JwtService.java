package com.boss.bossBackend.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username, List<String> roles){
        Map<String,Object> claims = new HashMap<>();
        claims.put("roles",roles);
        return createToken(claims,username);
    }

    public List<String> extractRoles(String token){
        return getClaimsFromToken(token).get("roles",List.class);
    }

    public Boolean validateToken(String token,String username){
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token){
        return getClaimsFromToken(token).getSubject();
    }

    public Date extractExpiration(String token){
        return getClaimsFromToken(token).getExpiration();
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    public String createToken(Map<String,Object> claims,String username){
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(),Jwts.SIG.HS256)
                .compact();
    }

    public SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
