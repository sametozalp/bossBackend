package com.boss.bossBackend.exception.deskException;

public class DeskNotFoundException extends RuntimeException {

    public DeskNotFoundException(String message) {
        super(message);
    }
}
