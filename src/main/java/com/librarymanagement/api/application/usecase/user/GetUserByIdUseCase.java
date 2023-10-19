package com.librarymanagement.api.application.usecase.user;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.domain.repositories.UserRepository;
import java.util.UUID;

public class GetUserByIdUseCase {

  private final UserRepository userRepo;

  public GetUserByIdUseCase(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public User execute(UUID id) {
    var user = userRepo.findById(id);

    if (user == null) {
      throw new UserNotFoundException();
    }

    return user;
  }
}
