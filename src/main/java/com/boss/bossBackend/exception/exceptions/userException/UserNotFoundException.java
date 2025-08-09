package com.boss.bossBackend.exception.exceptions.userException;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
