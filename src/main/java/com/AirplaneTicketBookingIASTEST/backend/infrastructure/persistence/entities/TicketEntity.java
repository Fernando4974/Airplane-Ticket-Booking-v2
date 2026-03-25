package com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "Tickets")
@AllArgsConstructor @NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ticketCode;
    @Column(nullable = false, length = 30)
    private String passengerDNI;
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @Column(nullable = false, precision = 12, scale = 2)
    @NotNull()
    private BigDecimal price;

}
