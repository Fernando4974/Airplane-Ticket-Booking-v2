package com.AirplaneTicketBookingIASTEST.backend.domain.exception.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.BusinessException;

public class EmptyTicketListException extends BusinessException {
    public EmptyTicketListException() {
        super("This booking does not have any tickets assigned");
    }
}
