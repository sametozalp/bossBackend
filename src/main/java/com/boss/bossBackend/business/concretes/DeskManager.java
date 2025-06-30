package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.business.abstracts.RoomService;
import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.DeskRepository;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.Room;
import com.boss.bossBackend.exception.deskException.DeskNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeskManager implements DeskService {

    private final DeskRepository repository;
    private final RoomService roomService;

    public DeskManager(DeskRepository repository, RoomService roomService) {
        this.repository = repository;
        this.roomService = roomService;
    }

    @Override
    public DataResult<Desk> findById(String deskId) {
        return new SuccessDataResult<>(repository.findById(deskId)
                .orElseThrow(() -> new DeskNotFoundException("Desk not found")));
    }

    @Override
    public DataResult<Desk> createDesk(CreateDeskRequest request) {
        Room room = roomService.findById(request.getRoomId());
        Desk desk = new Desk(room);
        return new SuccessDataResult<>(repository.save(desk));
    }
}
