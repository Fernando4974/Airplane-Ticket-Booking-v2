package com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.FlightStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FoundFlightDtoRequest extends RequestCreateFlightDto {
    private Long id;
    private FlightStatus flightStatus;
    private Integer occupiedSeats;

    public FoundFlightDtoRequest(
            Long id,
            String flightNumber,
            String origin,
            String destination,
            LocalDateTime leavedTime,
            LocalDateTime arrivedTime,
            Integer totalSeats,
            Integer occupiedSeats,
            FlightStatus flightStatus,
            BigDecimal price
    ) {

        super(flightNumber, origin, destination, leavedTime, arrivedTime, totalSeats, price);
        this.id = id;
        this.occupiedSeats = occupiedSeats;
        this.flightStatus = flightStatus;
    }
}