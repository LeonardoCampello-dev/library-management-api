package com.librarymanagement.api.ui.controller.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequestDTO(
    @NotBlank
    @Size(max = 50)
    String username,
    @NotBlank
    @Email
    String email,
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")
    String password,
    @NotBlank
    String firstName,
    @NotBlank
    String lastName
) {

}
