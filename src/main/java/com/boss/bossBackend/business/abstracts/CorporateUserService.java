package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;

public interface CorporateUserService {

    SuccessResult completeProfile(CorporateUserCompleteProfileRequest request);

}
