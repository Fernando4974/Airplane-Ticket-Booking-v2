package com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.InvalidLengthArguments;
import com.AirplaneTicketBookingIASTEST.backend.ObjectsMother;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.Booking;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    @DisplayName("Should Be Create With Correct Values")
    void ShouldBeCreateWithCorrectValues() {


        User user = new User(
                1L,
                "Fernando",
                "Villarreal",
                new UserEmail("Fernando@gmail.com"),
                "password123"
        );
        String passengerDNI = "12363568494";
        BigDecimal price = new BigDecimal("400000.000");


        assertAll(()->{
            Ticket ticket = new Ticket(
                    passengerDNI,
                    price
            );
        });
    }
    @Test
    @DisplayName("Should Be Create Without Correct DNI passenger")
    void ShouldNotCreateWithoutCorrectDNIPassenger() {

        Flight flight = ObjectsMother.createDefaultFlight();

        User user = new User(
                1L,
                "Fernando",
                "Villarreal",
                new UserEmail("Fernando@gmail.com"),
                "password123"
        );

        String passengerDNI = "DN1".repeat(31);
        Booking booking = new Booking(131L,"23645");
        BigDecimal price = new BigDecimal("400000.000");


        assertThrows(InvalidLengthArguments.class, ()->{
            Ticket ticket = new Ticket(
                    passengerDNI,
                    price
            );
        });
    }

}