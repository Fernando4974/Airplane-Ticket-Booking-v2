package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.controllers;

import com.AirplaneTicketBookingIASTEST.backend.application.port.ticket.TicketUseCasesPortIn;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.ticket.Ticket;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.request.ticket.RequestTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.dto.response.ResponseTicketDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.apiConfig.ApiResponse;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.mapper.ticket.TicketReqMapper;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.mapper.ticket.TicketResMapper;
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

        Ticket ticketReq = TicketReqMapper.toDomain(requestTicketDto);
        Ticket ticketSaved = this.ticketUseCasesPortIn.createTicket(ticketReq);

        ResponseTicketDto ticketRes = TicketResMapper.toResponse(ticketSaved);

        ApiResponse<ResponseTicketDto> response = ApiResponse.<ResponseTicketDto>builder()
                .data(ticketRes)
                .status(HttpStatus.CREATED.value())
                .message("Flight is saved")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
