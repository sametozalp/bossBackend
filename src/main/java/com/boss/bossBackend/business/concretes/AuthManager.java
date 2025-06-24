package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.AuthService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.util.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthManager(UserService userService, UserRepository userRepository, UserService userService1, PasswordEncoder passwordEncoder) {
        this.userService = userService1;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<UserResponse> login(User user) {

        UserResponse response = UserMapper.toResponse(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    public ResponseEntity<UserResponse> refreshToken(String refreshToken) {
//        if (!jwtService.isTokenValid(refreshToken)) {
//            throw new RuntimeException("Invalid refresh token");
//        }
//
//        User user = jwtService.extractUser(refreshToken);
//        return login(user);
//    }

    public ResponseEntity<UserResponse> register(UserRegisterRequest request) {

        userService.controlForRegisterParameters(request); // throw

        User user = UserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userService.add(user);
        return login(result);
    }

}
