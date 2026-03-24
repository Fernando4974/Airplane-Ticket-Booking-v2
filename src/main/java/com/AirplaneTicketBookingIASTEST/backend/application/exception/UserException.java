package com.AirplaneTicketBookingIASTEST.backend.application.exception;

public class UserException extends BusinessException {
    public UserException(String message) {
        super("User Exception : "+message);
    }
}
