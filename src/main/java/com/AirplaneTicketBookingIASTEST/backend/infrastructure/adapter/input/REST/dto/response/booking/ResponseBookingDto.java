package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.response.booking;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.booking.BookingStatus;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseBookingDto {

    @NotNull(message = "Booking id is required")
    Long id;
    @NotNull(message = "User id is required")
    Long idUser;
    @NotBlank(message = "Flight number is required")
    String flightNumber;
    @NotBlank(message = "Ticket list is required")
    List<Ticket> ticketList;
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    LocalDateTime bookingData;
    @NotNull(message = "Booking status is required")
    BookingStatus bookingStatus;
}
