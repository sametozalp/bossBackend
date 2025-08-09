package com.boss.bossBackend.exception.handlers;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.exceptions.listingException.ListingNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ListingExceptionHandler {

    @ExceptionHandler(ListingNotFound.class)
    public ResponseEntity<?> listingNotFound(ListingNotFound exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
