package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.entities.concretes.Appointment;

public interface AppointmentService {

    Appointment findById(String appointmentId);

    Appointment saveToDb(CreateAppointmentRequest request);

}
