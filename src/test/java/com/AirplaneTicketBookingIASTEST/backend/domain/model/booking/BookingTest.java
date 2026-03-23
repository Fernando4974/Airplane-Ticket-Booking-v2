package com.AirplaneTicketBookingIASTEST.backend.domain.model.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.booking.EmptyTicketListException;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ObjectsMother;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    @Test
    @DisplayName("ShouldCreateWithCorrectValues")
    void ShouldCreateWithCorrectValues() {
        User user = ObjectsMother.createDefaultUser();
        Flight flight = ObjectsMother.createDefaultFlight();

        Booking booking = new Booking(user, flight);

        assertAll(
                () -> assertNotNull(booking.getUser(), "User can not be null"),
                () -> assertNotNull(booking.getFlight(), "Flight can not be null"),

                () -> assertEquals(user.getId(), booking.getUser().getId(), "User Id must be equals"),
                () -> assertEquals(flight.getId(), booking.getFlight().getId(), "Flight Id must be equals"),

                () -> assertEquals(LocalDateTime.now()
                                .truncatedTo(ChronoUnit.SECONDS),
                        booking.getBookingDate().truncatedTo(ChronoUnit.SECONDS),
                        "Booking must be creates in the same day")

        );
    }

    @Test
    @DisplayName("ShouldCreateWithCorrectValues")
    void ShouldNotCreateWithNull() {
        User user = ObjectsMother.createDefaultUser();
        Flight flight = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Booking(user, flight);
        });

    }
    @Test
    @DisplayName("ShouldThrowExceptionWhenRequestAmountBookingOrTicketListWithoutTicketsAssigned")
    void ShouldThrowExceptionWhenRequestAmountBookingOrTicketListWithoutTicketsAssigned(){
        User user = ObjectsMother.createDefaultUser();
        Flight flight = ObjectsMother.createDefaultFlight();
       Booking booking = new Booking(user,flight);
       assertAll(
               ()->assertThrows(EmptyTicketListException.class, booking::getTotalAmount),
               ()->assertThrows(EmptyTicketListException.class, booking::getTicketList)
       );
    }


}

    //metodo para descubrir la execpcion
//    @Test
//    void discoverException() {
//        User user = new User(
//                1L,
//                "Fernando",
//                "Villarreal",
//                new UserEmail("Fernando@gmail.com"),
//                "password123"
//        );
//        Flight flight = null;
//        Exception exception = assertThrows(Exception.class, () -> {
//            new Booking(user,flight);
//        });
//
//        // Esto te dirá el nombre exacto de la clase en la consola
//        System.out.println("La excepción real es: " + exception.getClass().getName());
//        System.out.println("El mensaje es: " + exception.getMessage());
//    }

