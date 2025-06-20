package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.entities.concretes.User;

public interface UserService {

    User add(User user);
    Boolean controlForRegisterParameters(UserRegisterRequest request);
}
