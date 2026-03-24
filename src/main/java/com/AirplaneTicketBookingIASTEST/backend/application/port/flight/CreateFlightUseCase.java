package com.AirplaneTicketBookingIASTEST.backend.application.port.in.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

public interface CreateFlightUseCase {
    Flight execute(Flight flight);
}
