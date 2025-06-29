package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserRegisterResponse;
import com.boss.bossBackend.entities.concretes.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<UserRegisterResponse> login(User user);

    //public ResponseEntity<UserResponse> refreshToken(String refreshToken);

    public ResponseEntity<UserRegisterResponse> register(UserRegisterRequest request);
}
