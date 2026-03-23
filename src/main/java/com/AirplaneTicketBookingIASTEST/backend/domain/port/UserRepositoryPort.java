package com.AirplaneTicketBookingIASTEST.backend.domain.port;

import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User update(User user);

}
