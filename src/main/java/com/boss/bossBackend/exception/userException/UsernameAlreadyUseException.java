package com.boss.bossBackend.exception.userException;

public class UsernameAlreadyUseException extends RuntimeException {

    public UsernameAlreadyUseException(String message) {
        super(message);
    }
}
