package com.boss.bossBackend.exception.exceptionHandler;

import com.boss.bossBackend.common.utilities.results.ErrorResult;
import com.boss.bossBackend.exception.userException.EmailAlreadyUseException;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import com.boss.bossBackend.exception.userException.UsernameAlreadyUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFound(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(new ErrorResult(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyUseException.class)
    public ResponseEntity<?> emailAlreadyUse(EmailAlreadyUseException emailAlreadyUseException) {
        return new ResponseEntity<>(new ErrorResult(emailAlreadyUseException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameAlreadyUseException.class)
    public ResponseEntity<?> usernameAlreadyUse(UsernameAlreadyUseException usernameAlreadyUseException) {
        return new ResponseEntity<>(new ErrorResult(usernameAlreadyUseException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> userAlreadyExist(UserAlreadyExistException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
