package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.Room;
import com.boss.bossBackend.entities.enums.AppointmentStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentResponse {

    private UserDetailResponse investor;
    private UserDetailResponse entrepreneur;
    private UserDetailResponse requestBy;
    private AppointmentStatusEnum appointmentStatus;
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
        this.room = new RoomResponse(appointment.getRoom());
        this.desk = new DeskResponse(appointment.getDesk());
        this.onlineLink = appointment.getOnlineLink();
        this.listing = listing;
    }

    public UserDetailResponse getInvestor() {
        return investor;
    }

    public void setInvestor(UserDetailResponse investor) {
        this.investor = investor;
    }

    public UserDetailResponse getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(UserDetailResponse entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public UserDetailResponse getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(UserDetailResponse requestBy) {
        this.requestBy = requestBy;
    }

    public GetListingResponse getListing() {
        return listing;
    }

    public void setListing(GetListingResponse listing) {
        this.listing = listing;
    }

    public AppointmentStatusEnum getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatusEnum appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public MeetingTypeEnum getMeetingTypeEnum() {
        return meetingTypeEnum;
    }

    public void setMeetingTypeEnum(MeetingTypeEnum meetingTypeEnum) {
        this.meetingTypeEnum = meetingTypeEnum;
    }

    public RoomResponse getRoom() {
        return room;
    }

    public void setRoom(RoomResponse room) {
        this.room = room;
    }

    public DeskResponse getDesk() {
        return desk;
    }

    public void setDesk(DeskResponse desk) {
        this.desk = desk;
    }

    public String getOnlineLink() {
        return onlineLink;
    }

    public void setOnlineLink(String onlineLink) {
        this.onlineLink = onlineLink;
    }
}
