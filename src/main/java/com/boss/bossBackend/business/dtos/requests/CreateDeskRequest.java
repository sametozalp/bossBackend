package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public class CreateDeskRequest {

    @NotBlank(message = "Room id cannot be blank")
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
