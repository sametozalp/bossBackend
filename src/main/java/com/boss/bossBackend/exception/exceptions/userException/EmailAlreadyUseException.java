package com.boss.bossBackend.exception.exceptions.userException;

public class EmailAlreadyUseException extends RuntimeException{
    public EmailAlreadyUseException(String message) {
        super(message);
    }
}
