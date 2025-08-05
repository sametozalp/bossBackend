package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
