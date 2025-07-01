package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.AuthService;
import com.boss.bossBackend.business.dtos.requests.UserLoginRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(authService.login(userLoginRequest));
    }

//    @PostMapping("/refresh")
//    public ResponseEntity<UserResponse> refresh(@Valid @RequestParam String refreshToken) {
//        return authManager.refreshToken(refreshToken);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
