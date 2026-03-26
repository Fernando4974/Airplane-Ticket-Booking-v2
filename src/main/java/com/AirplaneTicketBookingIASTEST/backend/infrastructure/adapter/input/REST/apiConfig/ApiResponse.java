package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter.input.REST.apiConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private T data;
    private int status;
    private String message;
}