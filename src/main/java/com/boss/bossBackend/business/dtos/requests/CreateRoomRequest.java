package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRoomRequest {

    @NotBlank(message = "Technopark user id cannot be blank")
    @NotNull(message = "Technopark user id cannot be null")
    private String technoparkUserId;

    @NotBlank(message = "Room name cannot be blank")
    @NotNull(message = "Room name cannot be null")
    private String roomName;

    public String getTechnoparkUserId() {
        return technoparkUserId;
    }

    public void setTechnoparkUserId(String technoparkUserId) {
        this.technoparkUserId = technoparkUserId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
