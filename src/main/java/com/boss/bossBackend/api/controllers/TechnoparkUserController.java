package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/technoparkUser")
public class TechnoparkUserController {

    private final TechnoparkUserService technoparkUserService;

    public TechnoparkUserController(TechnoparkUserService technoparkUserService) {
        this.technoparkUserService = technoparkUserService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody TechnoparkRegisterRequest request) {
        return new ResponseEntity<>(technoparkUserService.saveToDb(request), HttpStatus.OK);
    }
}
