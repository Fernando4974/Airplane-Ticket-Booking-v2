package com.AirplaneTicketBookingIASTEST.backend.application.port.in.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;

public interface UpdateFlightUseCase {
    Flight execute(Flight flight);
}
