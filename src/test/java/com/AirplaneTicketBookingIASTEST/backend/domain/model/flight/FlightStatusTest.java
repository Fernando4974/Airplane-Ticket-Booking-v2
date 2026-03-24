package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

import com.AirplaneTicketBookingIASTEST.backend.ObjectsMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightStatusTest {

    @Test
    @DisplayName("Should Return True If Status Flight Is ON_TIME")
    void ShouldReturnTrueIfStatusFlightIsON_TIME(){
       Flight flight = ObjectsMother.createDefaultFlight();

        assertEquals(FlightStatus.ON_TIME, flight.getFlightStatus());
    }
    @Test
    @DisplayName("Should be modify flight status")
    void ShouldBeModifyFlightStatus(){
        Flight flight = new Flight(
                4051L,
                "405L",
                "Medellin",
                "Bogota",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(2),
                30,
                new BigDecimal("200.00")

        );
        flight.setFlightStatus(FlightStatus.CANCELLED);

        assertEquals(FlightStatus.CANCELLED, flight.getFlightStatus());
    }

}