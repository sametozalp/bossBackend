package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status", nullable = false)
    private ApprovalStatusEnum appointmentStatus = ApprovalStatusEnum.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Column(name = "meeting_time", nullable = false)
    private int meetingTime; // seconds

    @Column(name = "appointment_date_end")
    private LocalDateTime appointmentDateEnd;

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
        this.meetingTime = request.getMeetingTime();
        this.appointmentDateEnd = request.getAppointmentDate().plusMinutes(request.getMeetingTime());
    }
}
