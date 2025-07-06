package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.business.dtos.responses.AppointmentResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Appointment;

public interface AppointmentService {

    Appointment findById(String appointmentId);

    DataResult<AppointmentResponse> saveToDb(CreateAppointmentRequest request);

}
