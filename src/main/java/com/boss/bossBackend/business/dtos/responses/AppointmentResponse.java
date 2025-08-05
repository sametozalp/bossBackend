package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AppointmentResponse {

    private UserDetailResponse investor;
    private UserDetailResponse entrepreneur;
    private UserDetailResponse requestBy;
    private ApprovalStatusEnum appointmentStatus;
    private LocalDateTime appointmentDate;
    private MeetingTypeEnum meetingTypeEnum;
    private RoomResponse room;
    private DeskResponse desk;
    private String onlineLink;
    private GetListingResponse listing;

    public AppointmentResponse() {

    }

    public AppointmentResponse(Appointment appointment, UserDetailResponse investor, UserDetailResponse entrepreneur, UserDetailResponse requestBy, GetListingResponse listing) {
        this.investor = investor;
        this.entrepreneur = entrepreneur;
        this.requestBy = requestBy;
        this.appointmentStatus = appointment.getAppointmentStatus();
        this.appointmentDate = appointment.getAppointmentDate();
        this.meetingTypeEnum = appointment.getMeetingTypeEnum();
        this.room = appointment.getRoom() != null ? new RoomResponse(appointment.getRoom()) : null;
        this.desk = appointment.getDesk() != null ? new DeskResponse(appointment.getDesk()) : null;
        this.onlineLink = appointment.getOnlineLink();
        this.listing = listing;
    }
}
