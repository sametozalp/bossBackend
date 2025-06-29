package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IndividualUserCompleteProfileRequest {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotNull(message = "Phone number cannot be null")
    @NotBlank(message = "Phone number cannot be blank")
    private int phoneNumber;

    @NotNull(message = "Social security number cannot be null")
    @NotBlank(message = "Social security number cannot be blank")
    private int socialSecurityNumber;

    @NotNull(message = "User ID cannot be null")
    @NotBlank(message = "User ID cannot be blank")
    private String userId;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getUserId() {
        return userId;
    }
}
