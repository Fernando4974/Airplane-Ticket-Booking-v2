package com.AirplaneTicketBookingIASTEST.backend.application.port.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import org.springframework.context.annotation.Primary;


public interface CreateFlightUseCasePortIn {

  CreatedFlightDto execute(RequestCreateFlightDto requestCreateFlightDto);
}
