package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    DataResult<FullUserDetailResponse> login(User user);

    //public ResponseEntity<UserResponse> refreshToken(String refreshToken);

    DataResult<FullUserDetailResponse> register(UserRegisterRequest request);
}
