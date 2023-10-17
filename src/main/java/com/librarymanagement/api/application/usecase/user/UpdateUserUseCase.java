package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.domain.repositories.UserRepository;
import com.librarymanagement.api.ui.controller.dto.UpdateUserRequestDTO;

public class UpdateUserUseCase {

  private final UserRepository userRepo;

  public UpdateUserUseCase(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public User execute(UpdateUserRequestDTO dto) {
    User user = userRepo.findById(dto.userId());

    System.out.println(user);

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
      user.setUsername(dto.username());
    }

    return userRepo.save(user);
  }
}
