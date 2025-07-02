package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserLoginRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.User;

public interface AuthService {

    DataResult<FullUserDetailResponse> generateTokens(User user);

    //public ResponseEntity<UserResponse> refreshToken(String refreshToken);

    DataResult<FullUserDetailResponse> register(UserRegisterRequest request);

    DataResult<FullUserDetailResponse> register(TechnoparkRegisterRequest request);

    DataResult<FullUserDetailResponse> login(UserLoginRequest request);
}
