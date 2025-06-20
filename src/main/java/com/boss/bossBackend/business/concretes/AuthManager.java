package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.AuthService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.security.JwtService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthManager implements AuthService {

    private final JwtService jwtService;
    private final UserService userService;

    public AuthManager(JwtService jwtService, UserService userService, UserRepository userRepository, UserService userService1) {
        this.jwtService = jwtService;
        this.userService = userService1;
    }

    public Map<String, String> login(User user) {
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );
    }

    public Map<String, String> refreshToken(String refreshToken) {
        if (!jwtService.isTokenValid(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        User user = jwtService.extractUser(refreshToken);
        return login(user);
    }

    public Map<String, String> register(UserRegisterRequest request) {
        SuccessDataResult<UserResponse> result = userService.add(request);

        User user = userService.getByEmail(result.getData().getEmail());

        return login(user);
    }

}
