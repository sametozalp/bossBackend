package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.business.dtos.responses.CustomUserResponse;
import com.boss.bossBackend.business.dtos.responses.GetUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.User;

public interface UserService {

    User saveToDb(User user);

    void controlForRegisterParameters(UserRegisterRequest request);

    User updateUser(UserUpdateRequest request);

    User findById(String id);

    DataResult<GetUserDetailResponse> getUserDetails(String userId);

}
