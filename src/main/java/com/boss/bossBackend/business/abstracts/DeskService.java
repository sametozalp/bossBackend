package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DeskService {

    DataResult<Desk> findById(String deskId);

    Result createDesk(CreateDeskRequest request);

//    List<Desk> findByDeskAvailableAndRoom_TechnoparkUser(
//            DeskAvailableEnum deskAvailableEnum,
//            TechnoparkUser technoparkUser
//    );

    List<Desk> findAvailableDeskBetweenDatesAndTechnopark(LocalDateTime startDate, LocalDateTime endDate, String technoparkId);

}
