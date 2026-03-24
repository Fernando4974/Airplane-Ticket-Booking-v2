package com.AirplaneTicketBookingIASTEST.backend.domain.model.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.exception.booking.EmptyTicketListException;
import com.AirplaneTicketBookingIASTEST.backend.ObjectsMother;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    @Test
    @DisplayName("ShouldCreateWithCorrectValues")
    void ShouldCreateWithCorrectValues() {
        User user = ObjectsMother.createDefaultUser();
        Flight flight = ObjectsMother.createDefaultFlight();

        Booking booking = new Booking(43272413L,"A4312" );

        assertAll(


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


        assertThrows(NullPointerException.class, () -> {
            new Booking(user.getId(), null);
        });

    }
    @Test
    @DisplayName("ShouldThrowExceptionWhenRequestAmountBookingOrTicketListWithoutTicketsAssigned")
    void ShouldThrowExceptionWhenRequestAmountBookingOrTicketListWithoutTicketsAssigned(){
        User user = ObjectsMother.createDefaultUser();
        Flight flight = ObjectsMother.createDefaultFlight();
       Booking booking = new Booking(44L,"A44");
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

