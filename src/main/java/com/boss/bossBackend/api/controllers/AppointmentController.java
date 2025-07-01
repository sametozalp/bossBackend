package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.AppointmentService;
import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<?> createAppointment(CreateAppointmentRequest request) {
        return ResponseEntity.ok(new SuccessDataResult<>(appointmentService.saveToDb(request)));
    }
}
