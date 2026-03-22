package com.AirplaneTicketBookingIASTEST.backend.domain.exception;

public class InvalidLenghtArguments extends BusinessException {
    public InvalidLenghtArguments(String message) {
        super("The " + message + " must not be null, empty or more than 30 characters");
    }
}
