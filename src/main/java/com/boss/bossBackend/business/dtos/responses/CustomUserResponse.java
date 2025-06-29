package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.User;

public class CustomUserResponse {
    private String id;
    private String username;
    private String email;

    public CustomUserResponse() {

    }

    public CustomUserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
