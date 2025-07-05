package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDeskRequest {

    @NotBlank(message = "Room id cannot be blank")
    @NotNull(message = "Room id cannot be null")
    private String roomId;

    @NotBlank(message = "Desk name cannot be blank")
    @NotNull(message = "Desk name cannot be null")
    private String deskName;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }
}
