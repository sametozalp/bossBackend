package com.boss.bossBackend.handler;

import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.exception.exceptions.deskException.DeskNotFoundException;

import java.util.List;

public class FaceToFaceAppointmentHandler implements AppointmentHandler {

    private DeskService deskService;

    public FaceToFaceAppointmentHandler(DeskService deskService) {
        this.deskService = deskService;
    }

    @Override
    public void handle(Appointment appointment) {
        List<Desk> availableDesks = deskService.findAvailableDeskBetweenDatesAndTechnopark(
                appointment.getAppointmentDate(),
                appointment.getAppointmentDateEnd(),
                appointment.getTechnoparkUser().getId());

        if (!availableDesks.isEmpty()) {
            appointment.setRoom(availableDesks.get(0).getRoom());
            appointment.setDesk(availableDesks.get(0));
        } else {
            throw new DeskNotFoundException("Available desk not found");
        }
    }
}
