package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.concretes.AuthManager;
import com.boss.bossBackend.business.dtos.requests.UserLoginRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthManager authManager;

    public AuthController(AuthManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserLoginRequest userLoginRequest) {
        //return authManager.login(userLoginRequest);
        return new HashMap<>();
    }

//    @PostMapping("/refresh")
//    public ResponseEntity<UserResponse> refresh(@Valid @RequestParam String refreshToken) {
//        return authManager.refreshToken(refreshToken);
//    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        return authManager.register(request);
    }
}
