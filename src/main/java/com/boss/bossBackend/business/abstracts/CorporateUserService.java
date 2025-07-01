package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.GetUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.CorporateUser;

import java.util.Optional;

public interface CorporateUserService {

    DataResult<GetUserDetailResponse> completeProfile(CorporateUserCompleteProfileRequest request);

    CorporateUser findByUserId(String userId);

    Optional<CorporateUser> findByUserIdOptional(String userId);

}
