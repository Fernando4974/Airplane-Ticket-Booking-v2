package com.AirplaneTicketBookingIASTEST.backend.domain.exception.user;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.BusinessException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException() {
        super("User Email Format Invalid");
    }
}
