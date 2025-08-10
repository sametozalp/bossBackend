package com.boss.bossBackend.handler;

import com.boss.bossBackend.entities.concretes.Appointment;

public interface AppointmentHandler {
    void handle(Appointment appointment);
}
