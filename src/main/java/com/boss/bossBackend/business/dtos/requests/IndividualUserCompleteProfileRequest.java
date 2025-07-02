package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IndividualUserCompleteProfileRequest {

    @NotNull(message = "User ID cannot be null")
    @NotBlank(message = "User ID cannot be blank")
    private String userId;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotNull(message = "Phone number cannot be null")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotNull(message = "Social security number cannot be null")
    @NotBlank(message = "Social security number cannot be blank")
    private String socialSecurityNumber;

    @NotNull(message = "Associated Technopark cannot be null")
    @NotBlank(message = "Associated Technopark cannot be blank")
    private String associatedTechnopark;

    public String getAssociatedTechnopark() {
        return associatedTechnopark;
    }

    public void setAssociatedTechnopark(String associatedTechnopark) {
        this.associatedTechnopark = associatedTechnopark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
