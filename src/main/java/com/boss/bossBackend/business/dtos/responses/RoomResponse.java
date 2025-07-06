package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.Room;

public class RoomResponse {

    String id;
    String roomName;

    public RoomResponse() {

    }

    public RoomResponse(Room room) {
        if (room != null) {
            this.id = room.getId();
            this.roomName = room.getRoomName();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
