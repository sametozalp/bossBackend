package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.business.abstracts.RoomService;
import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.DeskRepository;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.Room;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import com.boss.bossBackend.exception.deskException.DeskNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Desk desk = new Desk(request, room);
        return new SuccessDataResult<>(repository.save(desk));
    }

//    @Override
//    public List<Desk> findByDeskAvailableAndRoom_TechnoparkUser(DeskAvailableEnum deskAvailableEnum, TechnoparkUser technoparkUser) {
//        List<Desk> availableDesks = repository.findByDeskAvailableAndRoom_TechnoparkUser(deskAvailableEnum, technoparkUser);
//        if (availableDesks.isEmpty()) {
//            throw new DeskNotFoundException("Available desk not found");
//        }
//        return availableDesks;
//    }

    @Override
    public Desk findAvailableDeskBetweenDatesAndTechnopark(LocalDateTime startDate, LocalDateTime endDate, String technoparkId) {
        Optional<Desk> availableDesk = repository.findAvailableDeskBetweenDatesAndTechnopark(startDate, endDate, technoparkId);

        if(availableDesk.isPresent()) {
            return availableDesk.get();
        }

        throw new DeskNotFoundException("Available desk not found");
    }

}
