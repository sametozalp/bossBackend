package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.enums.UserType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private UserType userType;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
