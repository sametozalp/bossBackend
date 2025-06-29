package com.boss.bossBackend.exception.userException;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String s) {
        super(s);
    }
}
