package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.FoundFlightDtoRequest;

import java.util.List;

public interface FindAllFlightsUseCase {
    List<FoundFlightDtoRequest> findAll();
}
