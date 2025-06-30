package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Desk;

public interface DeskService {

    DataResult<Desk> findById(String deskId);

    DataResult<Desk> createDesk(CreateDeskRequest request);

}
