package com.AirplaneTicketBookingIASTEST.backend.domain.exception;

public class InvalidLengthArguments extends BusinessException {
    public InvalidLengthArguments(String message) {
        super("The " + message + " must not be null, empty or more than 30 characters");
    }
}
