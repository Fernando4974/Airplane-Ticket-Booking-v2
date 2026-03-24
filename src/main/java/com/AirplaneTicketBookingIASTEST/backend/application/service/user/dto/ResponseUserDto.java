package com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto;


import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {

    private Long id;

    private String name;

    private String lastname;

    private UserEmail email;
}