package com.boss.bossBackend.exception.exceptionHandler;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.sectorException.SectorNotFoundException;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SectorExceptionHandler {

    @ExceptionHandler(SectorNotFoundException.class)
    public ResponseEntity<?> userAlreadyExist(SectorNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
