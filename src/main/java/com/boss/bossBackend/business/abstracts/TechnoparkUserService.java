package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;

import java.util.Optional;

public interface TechnoparkUserService {

    TechnoparkUser findByUserId(String technoparkId);

    DataResult<FullUserDetailResponse> saveToDb(TechnoparkRegisterRequest request, User savedUser);

    Optional<TechnoparkUser> findByUserIdOptional(String userId);
}
