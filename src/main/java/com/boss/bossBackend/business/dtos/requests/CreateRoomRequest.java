package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomRequest {

    @NotBlank(message = "Technopark user id cannot be blank")
    @NotNull(message = "Technopark user id cannot be null")
    private String technoparkId;

    @NotBlank(message = "Room name cannot be blank")
    @NotNull(message = "Room name cannot be null")
    private String roomName;
}
