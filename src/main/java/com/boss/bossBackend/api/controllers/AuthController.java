package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.concretes.AuthManager;
import com.boss.bossBackend.business.dtos.requests.UserLoginRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.Role;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
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


    @PostMapping("/refresh")
    public Map<String, String> refresh(@RequestParam String refreshToken) {
        return authManager.refreshToken(refreshToken);
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserRegisterRequest request) {
        return authManager.register(request);
    }
}
