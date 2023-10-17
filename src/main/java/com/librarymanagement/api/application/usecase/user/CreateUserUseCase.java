package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.repositories.UserRepository;
import com.librarymanagement.api.ui.controller.dto.CreateUserRequestDTO;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserUseCase {

  private final UserRepository userRepo;

  @Autowired
  public CreateUserUseCase(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public User execute(CreateUserRequestDTO dto) {
    var user = new User(
        null,
        dto.username(),
        dto.email(),
        dto.password(),
        dto.firstName(),
        dto.lastName(),
        LocalDateTime.now()
    );

    return userRepo.save(user);


  }
}
