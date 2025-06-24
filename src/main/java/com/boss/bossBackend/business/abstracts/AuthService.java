package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.entities.concretes.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<UserResponse> login(User user);

    //public ResponseEntity<UserResponse> refreshToken(String refreshToken);

    public ResponseEntity<UserResponse> register(UserRegisterRequest request);
}
