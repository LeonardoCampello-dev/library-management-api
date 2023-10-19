package com.librarymanagement.api.ui.controller.dto.user;

import com.librarymanagement.api.domain.entities.User;
import java.time.LocalDateTime;

public record UserResponseDTO(
    String username,
    String email,
    String fullName,
    LocalDateTime registrationDate
) {

  public UserResponseDTO(User user) {
    this(
        user.getUsername(),
        user.getEmail(),
        user.getFullName(),
        user.getRegistrationDate()
    );
  }
}
