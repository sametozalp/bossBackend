package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;

import java.time.LocalDateTime;
import java.util.Set;

public class UserResponse {
    private final String id;
    private final String username;
    private final String email;
    private Set<UserRole> authorities;
    private final LocalDateTime createdAt;
    private String accessToken;
    private String refreshToken;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.authorities = user.getUserRoles();
        this.createdAt = user.getCreatedAt();
    }

    public Set<UserRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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
