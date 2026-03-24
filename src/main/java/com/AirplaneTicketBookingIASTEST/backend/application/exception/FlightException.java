package com.AirplaneTicketBookingIASTEST.backend.application.exception;

public class FlightException extends BusinessException {
    public FlightException(String message) {
        super("User Exception: " + message);
    }
}
