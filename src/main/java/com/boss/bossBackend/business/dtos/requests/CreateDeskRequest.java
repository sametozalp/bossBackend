package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDeskRequest {

    @NotBlank(message = "Room id cannot be blank")
    @NotNull(message = "Room id cannot be null")
    private String roomId;

    @NotBlank(message = "Desk name cannot be blank")
    @NotNull(message = "Desk name cannot be null")
    private String deskName;
}
