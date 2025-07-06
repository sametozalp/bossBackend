package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateRoomRequest;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.Room;

public interface RoomService {

    void createRoom(CreateRoomRequest createRoomRequest);

    Room findById(String roomId);

}
