package com.AirplaneTicketBookingIASTEST.backend.application.service.flight;

import com.AirplaneTicketBookingIASTEST.backend.ObjectsMother;
import com.AirplaneTicketBookingIASTEST.backend.application.exception.FlightException;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.CreatedFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.flight.dto.RequestCreateFlightDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.Flight;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.FlightRepositoryPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

    @ExtendWith(MockitoExtension.class)
    class CreateFlightServiceTest {

        @Mock
        private FlightRepositoryPortOut flightRepositoryPortOut;

        @InjectMocks
        private CreateFlightService createFlightService;

        private RequestCreateFlightDto requestDto;
        private Flight flightEntity;

        @BeforeEach
        void setUp() {
            requestDto = ObjectsMother.createDefaultRequestCreateFlightDto();
            flightEntity = ObjectsMother.createDefaultFlight();
        }

        @Test
        @DisplayName("Should create a flight successfully when flight number is unique")
        void execute_Success() {

            when(flightRepositoryPortOut.findByFlightNumber(requestDto.getFlightNumber()))
                    .thenReturn(Optional.empty());

            when(flightRepositoryPortOut.save(any(Flight.class)))
                    .thenReturn(flightEntity);


            CreatedFlightDto result = createFlightService.execute(requestDto);


            assertNotNull(result);
            assertEquals(1L, result.getId());
            assertEquals("AV123", result.getFlightNumber());

            verify(flightRepositoryPortOut, times(1)).findByFlightNumber("AV123");
            verify(flightRepositoryPortOut, times(1)).save(any(Flight.class));
        }

        @Test
        @DisplayName("Should throw FlightException when flight number already exists")
        void execute_ThrowsException_WhenFlightExists() {

            when(flightRepositoryPortOut.findByFlightNumber(requestDto.getFlightNumber()))
                    .thenReturn(Optional.of(flightEntity));


            FlightException exception = assertThrows(FlightException.class, () -> {
                createFlightService.execute(requestDto);
            });

            assertEquals("User Exception: Flight is already Exist with same flight number", exception.getMessage());

            verify(flightRepositoryPortOut, never()).save(any(Flight.class));
        }
    }
