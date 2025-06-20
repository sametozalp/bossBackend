package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.entities.concretes.User;

public interface UserService {

    SuccessDataResult<UserResponse> add(UserRegisterRequest request);
    User getByEmail(String email);
    User getByUsername(String username);

}
