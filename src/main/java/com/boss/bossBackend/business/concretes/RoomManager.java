package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.RoomService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.dtos.requests.CreateRoomRequest;
import com.boss.bossBackend.dataAccess.abstracts.RoomRepository;
import com.boss.bossBackend.entities.concretes.Room;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.exception.exceptions.roomException.RoomNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoomManager implements RoomService {

    private final RoomRepository repository;
    private final TechnoparkUserService technoparkUserService;

    public RoomManager(RoomRepository repository, TechnoparkUserService technoparkUserService) {
        this.repository = repository;
        this.technoparkUserService = technoparkUserService;
    }

    @Override
    public void createRoom(CreateRoomRequest createRoomRequest) {
        TechnoparkUser technoparkUser = technoparkUserService.findById(createRoomRequest.getTechnoparkId());
        Room room = new Room(createRoomRequest, technoparkUser);
        repository.save(room);
    }

    @Override
    public Room findById(String roomId) {
        return repository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

}
