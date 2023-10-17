package com.librarymanagement.api.ui.controller.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record UpdateUserRequestDTO(
    @NotBlank
    UUID userId,
    String firstName,
    String lastName,
    String username
) {

}
