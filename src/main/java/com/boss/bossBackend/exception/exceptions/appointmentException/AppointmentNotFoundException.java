package com.boss.bossBackend.exception.exceptions.appointmentException;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
