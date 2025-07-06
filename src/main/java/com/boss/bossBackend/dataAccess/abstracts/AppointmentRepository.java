package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.AppointmentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    List<Appointment> findByAppointmentStatusAndTechnoparkUserOrderByCreatedAtDesc(
            AppointmentStatusEnum status,
            TechnoparkUser technoparkUser
    );

}
