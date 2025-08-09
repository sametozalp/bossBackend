package com.boss.bossBackend.exception.handlers;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.exceptions.roomException.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> roomNotFound(RoomNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
