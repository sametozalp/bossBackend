package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.RoomService;
import com.boss.bossBackend.business.dtos.requests.CreateRoomRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/createRoom")
    public ResponseEntity<?> createRoom(@Valid @RequestBody CreateRoomRequest request) {
        roomService.createRoom(request);
        return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
    }
}
