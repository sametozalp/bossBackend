package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.*;

public class UserRegisterRequest {
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(gmail|hotmail|yahoo|outlook)\\.com$", message = "Email error")
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
