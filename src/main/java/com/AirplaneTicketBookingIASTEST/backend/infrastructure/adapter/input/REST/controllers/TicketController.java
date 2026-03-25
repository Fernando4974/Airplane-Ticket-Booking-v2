package com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST;

import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCasesPortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.RequestTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.ticket.dto.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST.ApiConfig.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    private final TicketUseCasesPortIn ticketUseCasesPortIn;

    @PostMapping("/save")
    public final ResponseEntity<ApiResponse<ResponseTicketDto>>
    createTicket(@RequestBody RequestTicketDto requestTicketDto){
        ResponseTicketDto ticketSaved = this.ticketUseCasesPortIn.createTicket(requestTicketDto);
        ApiResponse<ResponseTicketDto> response = ApiResponse.<ResponseTicketDto>builder()
                .data(ticketSaved)
                .status(HttpStatus.CREATED.value())
                .message("Flight is saved")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




}
