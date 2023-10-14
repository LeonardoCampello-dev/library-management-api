package com.librarymanagement.api.ui.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateLibraryRequestDTO(
    @NotBlank
    String libraryName,
    @NotNull
    UUID userId
) {

}
