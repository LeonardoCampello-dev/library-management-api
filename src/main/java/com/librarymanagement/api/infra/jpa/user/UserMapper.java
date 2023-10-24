package com.librarymanagement.api.infra.jpa.user;

import com.librarymanagement.api.domain.entities.User;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toDomain(JpaUserEntity entity) {
    return new User(
        entity.getId(),
        entity.getUsername(),
        entity.getEmail(),
        entity.getPassword(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getRegistrationDate()
    );
  }

  public JpaUserEntity toEntity(User domain) {
    return new JpaUserEntity(
        domain.getId(),
        domain.getUsername(),
        domain.getEmail(),
        domain.getPassword(),
        domain.getFirstName(),
        domain.getLastName(),
        domain.getRegistrationDate(),
        // TODO temporário
        new ArrayList<>()
    );
  }
}
