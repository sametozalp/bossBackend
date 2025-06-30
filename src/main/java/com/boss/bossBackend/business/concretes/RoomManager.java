package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.RoomService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.dtos.requests.CreateRoomRequest;
import com.boss.bossBackend.dataAccess.abstracts.RoomRepository;
import com.boss.bossBackend.entities.concretes.Room;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
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
    public Room createRoom(CreateRoomRequest createRoomRequest) {
        TechnoparkUser technoparkUser = technoparkUserService.findByUserId(createRoomRequest.getTechnoparkUserId());
        Room room = new Room(technoparkUser);
        return repository.save(room);
    }

}
