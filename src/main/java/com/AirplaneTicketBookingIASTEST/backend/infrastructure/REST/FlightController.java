package com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST;

import com.AirplaneTicketBookingIASTEST.backend.application.port.flight.CreateFlightUseCase;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
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
    public CreatedFlightDto createFlight(@RequestBody RequestCreateFlightDto requestCreateFlightDto){
        return this.createFlightUseCase.execute(requestCreateFlightDto);
    }
}
