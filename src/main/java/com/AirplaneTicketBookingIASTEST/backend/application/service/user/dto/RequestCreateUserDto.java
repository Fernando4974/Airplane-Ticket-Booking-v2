package com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateUserDto {

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 30, message = "Name must not exceed 30 characters")
    private String name;

    @NotBlank(message = "Lastname cannot be empty")
    @Size(max = 30, message = "Lastname must not exceed 30 characters")
    private String lastname;

    @NotBlank(message = "Email cannot be empty")
    private UserEmail email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    private String password;
}