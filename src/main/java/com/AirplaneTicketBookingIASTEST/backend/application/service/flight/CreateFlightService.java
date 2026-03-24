package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFlightService implements CreateFlightUseCase {

    private final FlightRepositoryPortIn flightRepositoryPortIn;


    @Override
    public CreatedFlightDto execute(RequestCreateFlightDto requestCreateFlightDto){


      flightRepositoryPortIn.findByFlightNumber(requestCreateFlightDto.getFlightNumber())
                .ifPresent( exist -> {
                    throw new FlightException("Flight is already Exist with same flight number");
                });

        Flight flight = new Flight(
                null,
                requestCreateFlightDto.getFlightNumber(),
                requestCreateFlightDto.getOrigin(),
                requestCreateFlightDto.getDestination(),
                requestCreateFlightDto.getLeavedTime(),
                requestCreateFlightDto.getArrivedTime(),
                requestCreateFlightDto.getTotalSeats(),
                requestCreateFlightDto.getPrice()
        );
        Flight savedFlight = flightRepositoryPortIn.save(flight);

        return new CreatedFlightDto(
                savedFlight.getId(),
                savedFlight.getFlightNumber(),
                savedFlight.getOrigin(),
                savedFlight.getDestination(),
                savedFlight.getLeavedTime(),
                savedFlight.getArrivedTime(),
                savedFlight.getTotalSeats(),
                savedFlight.getPrice()
        );

    }
}
