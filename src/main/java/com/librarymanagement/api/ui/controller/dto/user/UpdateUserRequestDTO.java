package com.librarymanagement.api.ui.controller.dto.user;

public record UpdateUserRequestDTO(
    String firstName,
    String lastName,
    String username
) {

}
