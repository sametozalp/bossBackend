package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;

public interface IndividualUserService {

    SuccessResult completeProfile(IndividualUserCompleteProfileRequest request);

}
