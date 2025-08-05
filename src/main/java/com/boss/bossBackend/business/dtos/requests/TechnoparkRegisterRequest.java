package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnoparkRegisterRequest {

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

    @NotNull(message = "Location cannot be null")
    @NotBlank(message = "Location cannot be blank")
    private String location;

    @NotNull(message = "Technopark name cannot be null")
    @NotBlank(message = "Technopark name cannot be blank")
    private String technoparkName;

    public TechnoparkRegisterRequest() {

    }
}
