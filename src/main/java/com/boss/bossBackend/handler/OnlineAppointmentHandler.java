package com.boss.bossBackend.handler;

import com.boss.bossBackend.entities.concretes.Appointment;

public class OnlineAppointmentHandler implements AppointmentHandler {

    @Override
    public void handle(Appointment appointment) {
        appointment.setOnlineLink("gorusmelink.com");
    }
}
