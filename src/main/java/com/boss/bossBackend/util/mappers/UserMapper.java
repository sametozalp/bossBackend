package com.boss.bossBackend.util.mappers;

import com.boss.bossBackend.business.dtos.requests.UserRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.entities.concretes.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getUserType());
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUserType(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}
