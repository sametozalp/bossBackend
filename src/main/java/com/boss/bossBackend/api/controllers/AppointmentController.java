package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.AppointmentService;
import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PreAuthorize("hasAnyRole('ENTREPRENEUR', 'INVESTOR')")
    @PostMapping("/createAppointment")
    public ResponseEntity<?> createAppointment(@Valid @RequestBody CreateAppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.saveToDb(request));
    }

    @PreAuthorize("hasRole('TECHNOPARK')")
    @GetMapping("/getAppointmentDetails")
    ResponseEntity<?> getAppointmentDetails(ApprovalStatusEnum appointmentStatusEnum, String technoparkId) {
        return ResponseEntity.ok(appointmentService.findByAppointmentStatusAndTechnoparkUserOrderByCreatedAtDesc(appointmentStatusEnum, technoparkId));
    }
}
