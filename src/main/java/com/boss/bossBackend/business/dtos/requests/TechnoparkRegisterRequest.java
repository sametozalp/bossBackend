package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TechnoparkRegisterRequest {

    @NotNull
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(gmail|hotmail|yahoo|outlook)\\.com$", message = "Email error")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Password cannot be blank")
    private String location;

    @NotBlank(message = "Password cannot be blank")
    private String technoparkName;

    public TechnoparkRegisterRequest() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTechnoparkName() {
        return technoparkName;
    }

    public void setTechnoparkName(String technoparkName) {
        this.technoparkName = technoparkName;
    }
}
