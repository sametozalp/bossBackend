package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.entities.concretes.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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


//    @PostMapping("/updateUser")
//    public ResponseEntity<UserRegisterResponse> updateUser(@RequestBody UserUpdateRequest request, Authentication authentication) {
//        String email = authentication.getName();
//        User updatedUser = userService.updateUser(request);
//        return new ResponseEntity<>(UserMapper.toResponse(updatedUser), HttpStatus.OK);
//    }


    @PreAuthorize("hasAnyRole('ENTREPRENEUR', 'INVESTOR')")
    @GetMapping("/getUserDetails")
    public ResponseEntity<?> getUserDetails(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getUserDetails(userId));
    }

}