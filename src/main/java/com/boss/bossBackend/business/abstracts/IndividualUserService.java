package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.GetUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.IndividualUser;

import java.util.Optional;

public interface IndividualUserService {

    DataResult<GetUserDetailResponse> completeProfile(IndividualUserCompleteProfileRequest request);

    IndividualUser findByUserId(String userId);

    Optional<IndividualUser> findByUserIdOptional(String userId);

}
