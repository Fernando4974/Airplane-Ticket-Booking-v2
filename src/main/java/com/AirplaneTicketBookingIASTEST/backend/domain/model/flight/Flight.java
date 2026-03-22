package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightDateException;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightOccupiedSeats;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
public class Flight {

    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime leavedTime;
    private LocalDateTime arrivedTime;
    private Integer totalSeats;
    private Integer occupiedSeats;
    private FlightStatus flightStatus;
    public BigDecimal price;


    public Flight(
            String flightNumber,
            String origin,
            String destination,
            LocalDateTime leavedTime,
            LocalDateTime arrivedTime,
            Integer occupiedSeats,
            Integer totalSeats,
            BigDecimal price

    ) {
        if (totalSeats < 0) {
            throw new InvalidFlightOccupiedSeats();
        }
        if (arrivedTime.isBefore(leavedTime))
            throw new InvalidFlightDateException();

        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.leavedTime = leavedTime;
        this.arrivedTime = arrivedTime;
        this.totalSeats= totalSeats ;
        this.occupiedSeats= occupiedSeats;
        this.flightStatus = FlightStatus.ON_TIME;
        this.price = price;

    }
}

