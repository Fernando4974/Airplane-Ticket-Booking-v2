package com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST.ApiConfig;

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