package com.boss.bossBackend.exception;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class BossExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFound(UserNotFoundException userNotFoundException) {

        return new ResponseEntity<>(new ErrorResult(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
