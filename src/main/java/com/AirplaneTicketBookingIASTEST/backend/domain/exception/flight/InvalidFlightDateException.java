package com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.BusinessException;

public class InvalidFlightDateException extends BusinessException {
    public InvalidFlightDateException() {
        super("Arrive date can not be before Leave Date");
    }
}
