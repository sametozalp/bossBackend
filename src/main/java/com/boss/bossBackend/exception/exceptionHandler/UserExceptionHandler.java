package com.boss.bossBackend.exception.exceptionHandler;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.userException.EmailAlreadyUseException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler extends BossExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFound(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(new ErrorResult(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyUseException.class)
    public ResponseEntity<?> emailAlreadyUse(EmailAlreadyUseException emailAlreadyUseException) {
        return new ResponseEntity<>(new ErrorResult(emailAlreadyUseException.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
