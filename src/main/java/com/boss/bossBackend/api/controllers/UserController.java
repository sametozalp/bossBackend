package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @PostMapping(value = "/add")
//    public ResponseEntity<?> add(@Valid @RequestBody UserRegisterRequest request) {
//        SuccessDataResult<UserResponse> response = userService.add(request);
//        return ResponseEntity.ok(response);
//    }

//    @PostMapping("/save")
//    public ResponseEntity<?> save(@Valid @RequestBody UserRequest request) {
//        SuccessDataResult<UserResponse> response = userService.save(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/auth")
//    public ResponseEntity<?> auth(@Valid @RequestBody UserRequest request) {
//        return new ResponseEntity<>(userService.save(request));
//    }
}
