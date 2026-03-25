package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateFlightService implements CreateFlightUseCase {

    private final FlightRepositoryPortOut flightRepositoryPortOut;


    @Override
    public CreatedFlightDto execute(RequestCreateFlightDto requestCreateFlightDto){

        log.info("INITIALIZING TRANSACTION / Create Flight");
      flightRepositoryPortOut.findByFlightNumber(requestCreateFlightDto.getFlightNumber())
                .ifPresent( exist -> {
                    log.warn("TRANSACTION FAIL: NumberFlight : {} , is already exist",
                             requestCreateFlightDto.getFlightNumber());

                    throw new FlightException("Flight is already Exist with same flight number");
                });
      try {

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
          Flight savedFlight = flightRepositoryPortOut.save(flight);
          log.info("TRANSACTION COMPLETED / Flight #{} TO {}, IS SAVED"
                  , requestCreateFlightDto.getFlightNumber()
                  , requestCreateFlightDto.getDestination());

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
      } catch (Exception e) {
          log.error("TRANSACTION ERROR / MASSIVE ERROR, DATA ENTITY: {} ERROR :  {}",
                  requestCreateFlightDto.getFlightNumber(), e.getMessage());
          throw new RuntimeException(e);
      }

    }
}
