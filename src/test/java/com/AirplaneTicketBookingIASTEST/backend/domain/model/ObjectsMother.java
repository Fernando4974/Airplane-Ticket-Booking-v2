package com.AirplaneTicketBookingIASTEST.backend.domain.model;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ObjectsMother {
    public static User createDefaultUser(){
        Long id = 1L;
        String name = "Fernando";
        String lastname = "Villarreal";
        UserEmail userEmail = new UserEmail("fernando@gmail.com");
        String password = "password123";

      return new User(id,name,lastname,userEmail,password);
    }
    public static Flight createDefaultFlight(){
        Long id= 122L;
        String flightNumber = "A204";
        String origin = "Bogota";
        String destination = "Medellin";
        LocalDateTime leavedTime = LocalDateTime.now().plusHours(2);
        LocalDateTime arrivedTime = LocalDateTime.now().plusDays(2);
        Integer totalSeats = 40;
        BigDecimal price = new BigDecimal("400000.00");


        return new Flight(
                id,
                flightNumber,
                origin,
                destination,
                leavedTime,
                arrivedTime,
                totalSeats,
                price
        );
    }
}
