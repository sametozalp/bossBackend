package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.IndividualUser;

import java.util.Optional;

public interface IndividualUserService {

    SuccessResult completeProfile(IndividualUserCompleteProfileRequest request);

    IndividualUser findByUserId(String userId);

}
