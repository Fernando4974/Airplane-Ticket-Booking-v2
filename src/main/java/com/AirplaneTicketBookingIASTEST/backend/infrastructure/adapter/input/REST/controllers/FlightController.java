package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.controllers;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCasePortIn;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.apiConfig.ApiResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Primary
@RestController
@RequestMapping("/flight")
public class FlightController {
    public final CreateFlightUseCasePortIn createFlightUseCasePortIn;

    public FlightController(CreateFlightUseCasePortIn createFlightUseCasePortIn) {
        this.createFlightUseCasePortIn = createFlightUseCasePortIn;
    }


    @PostMapping("/save")
    public ResponseEntity<ApiResponse<CreatedFlightDto>> createFlight(@RequestBody RequestCreateFlightDto requestCreateFlightDto){
        CreatedFlightDto savedFlight = this.createFlightUseCasePortIn.execute(requestCreateFlightDto);
        ApiResponse<CreatedFlightDto> response = ApiResponse.<CreatedFlightDto>builder()
                .data(savedFlight)
                .status(HttpStatus.CREATED.value())
                .message("Flight is saved")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
