package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;

public interface UserService {

    SuccessDataResult<UserResponse> add(UserRequest request);

}
