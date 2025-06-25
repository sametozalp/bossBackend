package com.boss.bossBackend.util.mappers;

import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.entities.concretes.User;

public class UserMapper {

    public static User toEntity(UserRegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user);
    }
}
