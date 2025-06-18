package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.business.dtos.requests.UserRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.boss.bossBackend.business.mappers.UserMapper;

@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserManager(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SuccessDataResult<UserResponse> add(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }

        User user = UserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        UserResponse response = UserMapper.toResponse(savedUser);

        return new SuccessDataResult<UserResponse>(response);
    }
}
