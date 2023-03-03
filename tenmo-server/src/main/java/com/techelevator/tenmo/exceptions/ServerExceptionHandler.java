package com.techelevator.tenmo.exceptions;

import com.techelevator.tenmo.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                resourceNotFoundException.getMessage(),
                resourceNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {InvalidResourceException.class})
     public ResponseEntity<Object> handleInvalidResourceException(InvalidResourceException invalidResourceException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                invalidResourceException.getMessage(),
                invalidResourceException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
