package com.boss.bossBackend.exception.userException;

public class EmailAlreadyUseException extends RuntimeException{
    public EmailAlreadyUseException(String message) {
        super(message);
    }
}
