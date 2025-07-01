package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserUpdateRequest {

    @NotNull(message = "Id cannot be null")
    @NotBlank(message = "Id cannot be blank")
    private String id;

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(gmail|hotmail|yahoo|outlook)\\.com$", message = "Email error")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
