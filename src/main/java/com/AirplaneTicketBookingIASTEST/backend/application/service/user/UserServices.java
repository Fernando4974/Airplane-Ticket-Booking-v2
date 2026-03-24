package com.AirplaneTicketBookingIASTEST.backend.application.service.user;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.UserException;
import com.AirplaneTicketBookingIASTEST.backend.application.port.user.UserUseCases;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.RequestCreateUserDto;
import com.AirplaneTicketBookingIASTEST.backend.application.service.user.dto.ResponseUserDto;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.UserRepositoryPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServices implements UserUseCases {
    public final UserRepositoryPortIn userRepositoryPortIn;

    public UserServices(UserRepositoryPortIn userRepositoryPortIn) {
        this.userRepositoryPortIn = userRepositoryPortIn;
    }


    @Override
    public ResponseUserDto createUser(RequestCreateUserDto requestCreateUserDto) {
        log.info("INITIALISING TRANSACTION / CREATE USER ");
        try {
         userRepositoryPortIn.findByEmail(requestCreateUserDto.getEmail()).
                 ifPresent(user -> {
                     log.warn("TRANSACTION FAIL / Email {} is already exist",
                             requestCreateUserDto.getEmail());
                     throw new UserException("Email is already exist");
                 });
        User user = new User(
           null,
                requestCreateUserDto.getName(),
                requestCreateUserDto.getLastname(),
                requestCreateUserDto.getEmail(),
                requestCreateUserDto.getPassword()
        );

            User userSaved = this.userRepositoryPortIn.save(user);

            return new ResponseUserDto(
                    userSaved.getId(),
                    userSaved.getName(),
                    userSaved.getLastname(),
                    userSaved.getEmail()
            );
        } catch (Exception e) {
            log.error("TRANSACTION ERROR: {}", e.toString());
            throw new UserException("Cant be created the user by error: "+ e.toString());
        }


    }

    @Override
    public ResponseUserDto findUserByEmail(String email) {
      log.info("INITIALISING TRANSACTION / find user by email");
      UserEmail emailFormated = new UserEmail(email);
      try {
          User user = this.userRepositoryPortIn.findByEmail(emailFormated).orElseThrow(
                  ()-> new UserException("User Not found")

          );
          return new ResponseUserDto(
                  user.getId(),
                  user.getName(),
                  user.getLastname(),
                  user.getEmail()
          );
      }catch (Exception e){

          log.info("TRANSACTION ERROR: {}", e.toString());
          throw new UserException("User search error: "+e.toString());


      }
    }
}
