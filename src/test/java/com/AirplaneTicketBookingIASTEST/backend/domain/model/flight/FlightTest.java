package com.AirplaneTicketBookingIASTEST.backend.domain.model.flight;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightDateException;
import com.AirplaneTicketBookingIASTEST.backend.domain.exception.flight.InvalidFlightOccupiedSeats;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    @Test
    @DisplayName("Should be created with correct params ")
    void shouldBeCreatedWithCorrectValues() {
        String expectedNumber = "A204";
        BigDecimal expectedPrice = new BigDecimal("400.00");
        LocalDateTime leaveDate = LocalDateTime.now().plusHours(2);

        Flight flight = new Flight(
                expectedNumber,
                "Bogota",
                "Medellin",
                leaveDate,
                leaveDate.plusDays(2),
                20,
                40,
                expectedPrice
        );

        assertAll(
                () -> assertEquals(expectedNumber, flight.getFlightNumber(), "Number flight FAIL"),
                () -> assertEquals("Bogota", flight.getOrigin(), "Origin FAIL"),
                () -> assertEquals(20, flight.getOccupiedSeats(), "Seats Occupied FAIL"),
                () -> assertEquals(0, expectedPrice.compareTo(flight.getPrice()), "Price Fail")
        );
    }
    @Test
    @DisplayName("Should throw a exception when totalseats is less 0")
    void shouldThrowExceptionWheTotalSeatsIsLess0()
    {
        assertThrows(InvalidFlightOccupiedSeats.class, ()->{
            new Flight(
                    "A204",
                    "Bogota",
                    "Medellin",
                    LocalDateTime.now().plusHours(2),
                    LocalDateTime.now().plusDays(2),
                    20,
                    -1,
                    new BigDecimal("400.00")
            );
        });
    }
    @Test
    @DisplayName("ShouldTheowExceptionWhenArrivedTimeIsBeforeToLeavedTime")
        void ShouldTheowExceptionWhenArrivedTimeIsBeforeToLeavedTime(){
        assertThrows(InvalidFlightDateException.class, ()->{
            new Flight(
                    "405L",
                    "Medellin",
                    "Bogota",
                    LocalDateTime.now(),
                    LocalDateTime.now().minusDays(1),
                    20,
                    30,
                    new BigDecimal("200.00")

            );
        });
        }

}