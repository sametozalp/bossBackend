package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;

public interface TechnoparkUserService {

    TechnoparkUser findByUserId(String userId);

    TechnoparkUser save(TechnoparkRegisterRequest request);
}
