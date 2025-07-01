package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.AppointmentService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.dataAccess.abstracts.AppointmentRepository;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.appointmentException.AppointmentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentManager implements AppointmentService {

    private final AppointmentRepository repository;
    private final UserService userService;
    private final TechnoparkUserService technoparkUserService;

    public AppointmentManager(AppointmentRepository repository, UserService userService, TechnoparkUserService technoparkUserService) {
        this.repository = repository;
        this.userService = userService;
        this.technoparkUserService = technoparkUserService;
    }

    @Override
    public Appointment findById(String appointmentId) {
        return repository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
    }

    @Override
    public Appointment saveToDb(CreateAppointmentRequest request) {
        User investor = userService.findById(request.getInvestorId());
        User entrepreneur = userService.findById(request.getEntrepreneurId());
        User requestBy = userService.findById(request.getRequestById());
        TechnoparkUser technoparkUser = technoparkUserService.findByUserId(request.getTechnoparkId());
        Appointment appointment = new Appointment(request, investor, entrepreneur, requestBy, technoparkUser);
        return repository.save(appointment);
    }
}
