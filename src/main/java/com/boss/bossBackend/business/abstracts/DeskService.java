package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;

import java.util.List;

public interface DeskService {

    DataResult<Desk> findById(String deskId);

    DataResult<Desk> createDesk(CreateDeskRequest request);

    List<Desk> findByDeskAvailableAndRoom_TechnoparkUser(
            DeskAvailableEnum deskAvailableEnum,
            TechnoparkUser technoparkUser
    );

    Desk updateDeskAsNotAvailable(String deskId);

}
