package com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ResponseTicketDto {
    @NotBlank()
    private Long idTicket;
    @NotBlank(message = "Passenger DNI cannot be empty")
    @Size(max = 30, message = "Passenger DNI must not exceed 30 characters")
    private String passengerDNI;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull
    private LocalDateTime createdDate;
    @NotBlank(message = "Price cannot be empty")
    @Min(0)
    private BigDecimal price;


    public ResponseTicketDto(Long idTicket, String passengerDNI, LocalDateTime createdDate, BigDecimal price) {
        this.idTicket = idTicket;
        this.passengerDNI = passengerDNI;
        this.createdDate = createdDate;
        this.price = price;
    }
}
