package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/desks")
public class DeskController {

    private final DeskService deskService;

    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @PostMapping("/createDesk")
    public ResponseEntity<?> createDesk(CreateDeskRequest request) {
        return ResponseEntity.ok(deskService.createDesk(request));
    }
}
