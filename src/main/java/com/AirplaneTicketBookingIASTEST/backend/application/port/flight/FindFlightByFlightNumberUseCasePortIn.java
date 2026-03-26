package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.FoundFlightDtoRequest;

public interface FindFlightByFlightNumberUseCasePortIn {

    public FoundFlightDtoRequest execute(String id);
}
