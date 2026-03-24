package com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST;

import com.AirplaneTicketBookingIASTEST.backend.application.port.user.UserUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.UserServices;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.RequestCreateUserDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.ResponseUserDto;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.REST.ApiConfig.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserServices userServices;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<ResponseUserDto>>
    createUser(@RequestBody RequestCreateUserDto requestCreateUserDto){
        ResponseUserDto user = this.userServices.createUser(requestCreateUserDto);
        ApiResponse<ResponseUserDto> response = ApiResponse.<ResponseUserDto>builder()
                        .data(user)
                        .status(HttpStatus.CREATED.value())
                        .message("User Saved")
                        .build();
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    };
    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<ResponseUserDto>>
    findUserByEmail(@PathVariable String email){
        ResponseUserDto user = this.userServices.findUserByEmail(email);
        ApiResponse<ResponseUserDto> response = ApiResponse.<ResponseUserDto>builder()
                .data(user)
                .status(HttpStatus.FOUND.value())
                .message("User Found").build();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
