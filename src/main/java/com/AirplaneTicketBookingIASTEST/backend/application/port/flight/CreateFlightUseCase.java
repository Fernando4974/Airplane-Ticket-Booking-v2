package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;

public interface CreateFlightUseCase {
  CreatedFlightDto execute(RequestCreateFlightDto requestCreateFlightDto);
}
