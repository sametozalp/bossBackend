package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.AppointmentEnum;
import jakarta.persistence.*;

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

    @Column(name = "status", nullable = false)
    private AppointmentEnum appointmentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    public Appointment() {
    }

    public Appointment(CreateAppointmentRequest request, User investor, User entrepreneur, User requestBy, TechnoparkUser technoparkUser) {

        this.investor = investor;
        this.entrepreneur = entrepreneur;
        this.technoparkUser = technoparkUser;
        this.requestBy = requestBy;
        this.appointmentStatus = AppointmentEnum.WAITING;

    }


}
