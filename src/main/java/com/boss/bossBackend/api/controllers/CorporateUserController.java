package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corporateUser")
public class CorporateUserController {

    private final CorporateUserService corporateUserService;

    public CorporateUserController(@Valid @RequestBody CorporateUserService corporateUserService) {
        this.corporateUserService = corporateUserService;
    }

    @PostMapping("/completeProfile")
    public ResponseEntity<?> completeProfile(@Valid @RequestBody CorporateUserCompleteProfileRequest request) {
        return ResponseEntity.ok(corporateUserService.completeProfile(request));
    }
}
