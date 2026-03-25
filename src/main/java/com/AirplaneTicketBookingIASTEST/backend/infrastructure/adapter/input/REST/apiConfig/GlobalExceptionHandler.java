package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.controllers.ApiConfig;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({FlightException.class, UserException.class})
    public ResponseEntity<ApiResponse<Object>> handleFlightException(FlightException ex) {
        ApiResponse<Object> response = ApiResponse.builder()
                .data(null)
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralError(Exception ex) {
        ApiResponse<Object> response = ApiResponse.builder()
                .data(null)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Unexpected error: " + ex.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}