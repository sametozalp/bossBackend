package com.boss.bossBackend.exception.handlers;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.exceptions.generalException.OwnerViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(OwnerViolationException.class)
    public ResponseEntity<?> ownerViolationException(OwnerViolationException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
