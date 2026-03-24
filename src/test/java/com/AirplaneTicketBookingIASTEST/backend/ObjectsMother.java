package com.AirplaneTicketBookingIASTEST.backend;

import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
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
        Long id= 1L;
        String flightNumber = "AV123";
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
    public static RequestCreateFlightDto createDefaultRequestCreateFlightDto(){
        return new RequestCreateFlightDto(
                "AV123",
                "BOG",
                "MAD",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(10),
                150,
                new BigDecimal("500.00")
        );
    }
}
