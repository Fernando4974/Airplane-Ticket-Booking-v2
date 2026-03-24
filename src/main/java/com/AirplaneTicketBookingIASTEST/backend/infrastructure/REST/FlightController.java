package com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST.ApiConfig.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {
    public final CreateFlightUseCase createFlightUseCase;

    public FlightController(CreateFlightUseCase createFlightUseCase) {
        this.createFlightUseCase = createFlightUseCase;
    }


    @PostMapping("/save")
    public ResponseEntity<ApiResponse<CreatedFlightDto>> createFlight(@RequestBody RequestCreateFlightDto requestCreateFlightDto){
        CreatedFlightDto savedFlight = this.createFlightUseCase.execute(requestCreateFlightDto);
        ApiResponse<CreatedFlightDto> response = ApiResponse.<CreatedFlightDto>builder()
                .data(savedFlight)
                .status(HttpStatus.CREATED.value())
                .message("Flight is saved")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
