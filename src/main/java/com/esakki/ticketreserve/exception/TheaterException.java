package com.esakki.ticketreserve.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class TheaterException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TheaterNotFoundException.class)
    public final ResponseEntity<ApiError> handleTheaterNotFoundException(TheaterNotFoundException ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ApiError(httpStatus, ex), httpStatus);
    }
}
