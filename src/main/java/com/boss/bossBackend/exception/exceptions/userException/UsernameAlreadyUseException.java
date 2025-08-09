package com.boss.bossBackend.exception.exceptions.userException;

public class UsernameAlreadyUseException extends RuntimeException {

    public UsernameAlreadyUseException(String message) {
        super(message);
    }
}
