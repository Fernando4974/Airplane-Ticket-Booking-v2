package com.AirplaneTicketBookingIASTEST.backend.infrastructure.adapter;

import com.AirplaneTicketBookingIASTEST.backend.application.exception.UserException;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.User;
import com.AirplaneTicketBookingIASTEST.backend.domain.model.user.UserEmail;
import com.AirplaneTicketBookingIASTEST.backend.domain.port.UserRepositoryPortIn;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.JpaUserRepository;
import com.AirplaneTicketBookingIASTEST.backend.infrastructure.persistence.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaUserImplIn implements UserRepositoryPortIn {
    private final JpaUserRepository jpaUserRepository;


    @Override
    public User save(User user) {

        final UserEntity userEntity = new UserEntity(
                null,
                user.getName(),
                user.getLastname(),
                user.getEmail().value(),
                user.getPassword()
        );
        try {
            UserEntity userSaved = this.jpaUserRepository.save(userEntity);

        return new User(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getLastname(),
                new UserEmail(userSaved.getEmail()),
                userSaved.getPassword()
        );
        } catch (Exception e) {
            throw new UserException("TRANSACTION FAIL / ERROR : " + e.toString());
        }
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(UserEmail email) {
        return this.jpaUserRepository.findByEmail(email.value())
                .map(UserEntity::toDomain);

    }

    @Override
    public User update(User user) {
        return null;
    }
}
