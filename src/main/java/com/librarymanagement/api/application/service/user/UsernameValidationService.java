package com.librarymanagement.api.application.service.user;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UsernameAlreadyExistsException;
import com.librarymanagement.api.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsernameValidationService {

  private final UserRepository userRepo;

  public UsernameValidationService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public void validate(User user) {
    if (userRepo.existsByUsername(user.getUsername())) {
      throw new UsernameAlreadyExistsException(user.getUsername());
    }
  }
}
