package com.AirplaneTicketBookingIASTEST.backend.application.service.booking.dto;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Valid
@AllArgsConstructor @NoArgsConstructor
public class RequestBooingDTO {
    @NotNull
    Long idUser;
    @NotBlank
    String flightNumber;
    @NotNull(message = "Should have almost 1 ticket")
    List<Ticket> ticketList;


}
