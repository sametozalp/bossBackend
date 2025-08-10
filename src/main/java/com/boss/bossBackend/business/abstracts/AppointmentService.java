package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.business.dtos.requests.UpdateAppointmentStatusRequest;
import com.boss.bossBackend.business.dtos.responses.AppointmentResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;

import java.util.List;

public interface AppointmentService {

    Appointment findById(String appointmentId);

    DataResult<AppointmentResponse> saveToDb(CreateAppointmentRequest request);

    DataResult<List<AppointmentResponse>> findByAppointmentStatusAndTechnoparkUserOrderByCreatedAtDesc(
            ApprovalStatusEnum status,
            String technoparkUserId
    );

    DataResult<AppointmentResponse> updateAppointment(UpdateAppointmentStatusRequest updateAppointmentStatusRequest);

    DataResult<AppointmentResponse> updateAppointment(Appointment appointment);

    List<Appointment> findByAppointmentStatusAndMeetingTypeAndRoomIdIsNull(ApprovalStatusEnum appointmentStatus, MeetingTypeEnum meetingType);

}
