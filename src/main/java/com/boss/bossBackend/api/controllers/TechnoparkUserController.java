package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.business.dtos.responses.UserRegisterResponse;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.util.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technoparkUser")
public class TechnoparkUserController {

    private final TechnoparkUserService technoparkUserService;

    public TechnoparkUserController(TechnoparkUserService technoparkUserService) {
        this.technoparkUserService = technoparkUserService;
    }

    @PutMapping("/createUser")
    public ResponseEntity<TechnoparkUser> createUser(@RequestBody TechnoparkRegisterRequest request) {
        return new ResponseEntity<>(technoparkUserService.save(request), HttpStatus.OK);
    }
}
