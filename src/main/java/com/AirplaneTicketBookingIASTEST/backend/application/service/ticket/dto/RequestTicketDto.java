package com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RequestTicketDto {

    @NotBlank(message = "Passenger DNI cannot be empty")
    @Size(max = 30, message = "Passenger DNI must not exceed 30 characters")
    private String passengerDNI;
    @NotBlank(message = "Price cannot be empty")
    @Min(0)
    private BigDecimal price;

}
