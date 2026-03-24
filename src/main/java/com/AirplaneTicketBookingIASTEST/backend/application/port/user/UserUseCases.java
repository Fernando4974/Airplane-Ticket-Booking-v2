package com.AirplaneTicketBookingIASTEST.backend.application.port.user;

import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.RequestCreateUserDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.ResponseUserDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;

public interface UserUseCases {

ResponseUserDto createUser(RequestCreateUserDto requestCreateUserDto);
ResponseUserDto findUserByEmail(String email);
}
