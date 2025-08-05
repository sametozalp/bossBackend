package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
