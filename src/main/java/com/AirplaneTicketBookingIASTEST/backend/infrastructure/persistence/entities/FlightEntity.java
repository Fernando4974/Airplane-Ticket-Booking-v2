package com.AirplaneTicketBookingIASTEST.backend.infraestructure.persistence.entities;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.flight.FlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    @Data
    @Table(name = "flights")
    @AllArgsConstructor
    @NoArgsConstructor
    public class FlightEntity {
        @Id()
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true, nullable = false)
        private String flyNumber;
        @Column(nullable = false)
        @NotBlank(message = "Origin is requires")
        private String origin;
        @Column(nullable = false)
        @NotBlank(message = "Destination is requires")
        private String destination;
        @NotNull(message = "Leave time is requires")
        @Column(nullable = false)
        private LocalDateTime leaveTime;
        @NotNull(message = "Arrive time is required")
        @Column(nullable = false)
        private LocalDateTime arriveTime;
        @Min(0)
        @Column(nullable = false, precision = 12, scale = 2)
        @NotNull()
        private BigDecimal price;
        @Min(0)
        @NotNull
        private Integer totalSeats;
        @Min(0)
        @NotNull
        private Integer occupiedSeats;
        @Enumerated(EnumType.STRING)
        private FlightStatus flightStatus;
    }