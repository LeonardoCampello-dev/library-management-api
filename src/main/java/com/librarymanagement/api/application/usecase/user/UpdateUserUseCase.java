package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.domain.services.user.UsernameValidationService;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.domain.repositories.UserRepository;
import com.librarymanagement.api.ui.controller.dto.user.UpdateUserRequestDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

  private final UserRepository userRepo;

  private final UsernameValidationService usernameValidationService;

  public UpdateUserUseCase(
      UserRepository userRepo,
      UsernameValidationService usernameValidationService
  ) {
    this.userRepo = userRepo;
    this.usernameValidationService = usernameValidationService;
  }

  public User execute(
      UpdateUserRequestDTO dto,
      UUID userId
  ) {
    User user = userRepo.findById(userId);

    if (user == null) {
      throw new UserNotFoundException();
    }

    if (dto.firstName() != null) {

      user.setFirstName(dto.firstName());
    }

    if (dto.lastName() != null) {
      user.setLastName(dto.lastName());
    }

    if (dto.username() != null) {
      if (!user.getUsername().equals(dto.username())) {
        this.usernameValidationService.validate(user);
      }

      user.setUsername(dto.username());
    }

    return userRepo.save(user);
  }
}
