package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.AppointmentStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    private User investor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrepreneur_id", nullable = false)
    private User entrepreneur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_by", nullable = false)
    private User requestBy;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Column(name = "status", nullable = false)
    private AppointmentStatusEnum appointmentStatus = AppointmentStatusEnum.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "meeting_type", nullable = false)
    private MeetingTypeEnum meetingTypeEnum;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    @Column(name = "online_link")
    private String onlineLink;

    public Appointment() {
    }

    public Appointment(CreateAppointmentRequest request, User investor, User entrepreneur, User requestBy, TechnoparkUser technoparkUser) {
        this.investor = investor;
        this.entrepreneur = entrepreneur;
        this.technoparkUser = technoparkUser;
        this.requestBy = requestBy;
        this.appointmentDate = request.getAppointmentDate();
        this.meetingTypeEnum = request.getMeetingTypeEnum();
    }

    public User getInvestor() {
        return investor;
    }

    public void setInvestor(User investor) {
        this.investor = investor;
    }

    public User getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(User entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public User getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(User requestBy) {
        this.requestBy = requestBy;
    }

    public AppointmentStatusEnum getAppointmentStatus() {
        return appointmentStatus;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public void setAppointmentStatus(AppointmentStatusEnum appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public TechnoparkUser getTechnoparkUser() {
        return technoparkUser;
    }

    public void setTechnoparkUser(TechnoparkUser technoparkUser) {
        this.technoparkUser = technoparkUser;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public String getOnlineLink() {
        return onlineLink;
    }

    public void setOnlineLink(String onlineLink) {
        this.onlineLink = onlineLink;
    }
}
