package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightStatusTest {

    @Test
    @DisplayName("Should Return True If Status Flight Is ON_TIME")
    void ShouldReturnTrueIfStatusFlightIsON_TIME(){
       Flight flight = new Flight(
               "405L",
               "Medellin",
               "Bogota",
               LocalDateTime.now(),
               LocalDateTime.now().plusDays(2),
               20,
               30,
               new BigDecimal("200.00")

       );
        assertEquals("On time", flight.getFlightStatus());
    }
    @Test
    @DisplayName("Should Return True If Status Flight Is ON_TIME")
    void ShouldReturnFalseIfStatusFlightIsNotON_TIME(){
        Flight flight = new Flight(
                "405L",
                "Medellin",
                "Bogota",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(2),
                20,
                30,
                new BigDecimal("200.00")

        );
        flight.setFlightStatus(FlightStatus.CANCELLED);

        assertEquals("Canceled", flight.getFlightStatus());
    }

}