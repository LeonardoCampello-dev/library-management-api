package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.domain.services.user.PasswordService;
import com.librarymanagement.api.domain.services.user.UsernameValidationService;
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
  private final PasswordService passwordService;

  @Autowired
  public CreateUserUseCase(
      UserRepository userRepo,
      UsernameValidationService usernameValidationService,
      PasswordService passwordService
  ) {
    this.userRepo = userRepo;
    this.usernameValidationService = usernameValidationService;
    this.passwordService = passwordService;
  }

  public User execute(CreateUserRequestDTO dto) {
    var user = new User(
        null,
        dto.username(),
        dto.email(),
        passwordService.encode(dto.password()),
        dto.firstName(),
        dto.lastName(),
        LocalDateTime.now()
    );

    usernameValidationService.validate(user);

    return userRepo.save(user);
  }
}
