package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.concretes.AuthManager;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.Role;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthManager authManager;

    public AuthController(AuthManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        return authManager.login(user);
    }


    @PostMapping("/refresh")
    public Map<String, String> refresh(@RequestParam String refreshToken) {
        return authManager.refreshToken(refreshToken);
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestParam String username,
                                        @RequestParam String password,
                                        @RequestParam Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(username + "@gmail.com");

        return authManager.register(user);
    }

}
