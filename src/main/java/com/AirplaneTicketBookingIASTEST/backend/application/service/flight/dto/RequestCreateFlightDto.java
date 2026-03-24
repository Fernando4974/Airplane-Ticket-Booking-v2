package com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateFlightDto {


    @NotBlank(message = "Flight number is required")
    private String flightNumber;

    @NotBlank(message = "Flight origin is required")
    private String origin;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Leaved  date is required")
    private LocalDateTime leavedTime;

    @NotNull(message = "Arrived  date is required")
    private LocalDateTime arrivedTime;

    @NotNull(message = "Total seats is required")
    private Integer totalSeats;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;



}
