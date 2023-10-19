package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.application.service.user.UsernameValidationService;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.repositories.UserRepository;
import com.librarymanagement.api.ui.controller.dto.user.CreateUserRequestDTO;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

  private final UserRepository userRepo;
  private final UsernameValidationService usernameValidationService;

  @Autowired
  public CreateUserUseCase(
      UserRepository userRepo,
      UsernameValidationService usernameValidationService
  ) {
    this.userRepo = userRepo;
    this.usernameValidationService = usernameValidationService;
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

    usernameValidationService.validate(user);

    return userRepo.save(user);


  }
}
