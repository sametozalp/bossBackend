package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.entities.concretes.User;

import java.util.Map;

public interface AuthService {

    public Map<String, String> login(User user);

    public Map<String, String> refreshToken(String refreshToken);

    public Map<String, String> register(UserRegisterRequest request);
}
