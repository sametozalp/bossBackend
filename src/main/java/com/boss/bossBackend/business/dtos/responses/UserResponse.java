package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.Role;

import java.time.LocalDateTime;

public class UserResponse {
    private final Long id;
    private final String username;
    private final String email;
    private final Role role;
    private final LocalDateTime createdAt;
    private String accessToken;
    private String refreshToken;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
