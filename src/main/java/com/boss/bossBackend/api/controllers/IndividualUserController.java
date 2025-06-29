package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/individualUser")
public class IndividualUserController {

    private final IndividualUserService individualUserService;

    public IndividualUserController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @PostMapping("/completeProfile")
    public ResponseEntity<?> completeProfile(@Valid @RequestBody IndividualUserCompleteProfileRequest request) {
        return ResponseEntity.ok(individualUserService.completeProfile(request));
    }
}
