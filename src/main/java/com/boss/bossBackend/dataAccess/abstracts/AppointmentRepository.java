package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
