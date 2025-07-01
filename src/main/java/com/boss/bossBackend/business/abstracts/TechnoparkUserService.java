package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;

import java.util.Optional;

public interface TechnoparkUserService {

    TechnoparkUser findByUserId(String technoparkId);

    TechnoparkUser save(TechnoparkRegisterRequest request);

    Optional<TechnoparkUser> findByUserIdOptional(String userId);
}
