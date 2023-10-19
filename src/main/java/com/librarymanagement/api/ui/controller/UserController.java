package com.librarymanagement.api.ui.controller;

import com.librarymanagement.api.application.usecase.user.CreateUserUseCase;
import com.librarymanagement.api.application.usecase.user.GetUserByIdUseCase;
import com.librarymanagement.api.application.usecase.user.UpdateUserUseCase;
import com.librarymanagement.api.ui.controller.dto.user.CreateUserRequestDTO;
import com.librarymanagement.api.ui.controller.dto.user.UpdateUserRequestDTO;
import com.librarymanagement.api.ui.controller.dto.user.UserResponseDTO;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

  private final CreateUserUseCase createUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final GetUserByIdUseCase getUserByIdUseCase;

  @Autowired
  public UserController(
      CreateUserUseCase createUserUseCase,
      UpdateUserUseCase updateUserUseCase,
      GetUserByIdUseCase getUserByIdUseCase
  ) {
    this.createUserUseCase = createUserUseCase;
    this.updateUserUseCase = updateUserUseCase;
    this.getUserByIdUseCase = getUserByIdUseCase;
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
    var user = getUserByIdUseCase.execute(id);

    return ResponseEntity.ok().body(new UserResponseDTO(user));
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(
      @RequestBody
      @Valid
      CreateUserRequestDTO body
  ) {
    var createdUser = createUserUseCase.execute(body);

    var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(createdUser.getId()).toUri();

    return ResponseEntity.created(location).body(new UserResponseDTO(createdUser));
  }

  public ResponseEntity<UserResponseDTO> updateUser(
      @RequestBody @Valid
      UpdateUserRequestDTO body
  ) {
    var updatedUser = updateUserUseCase.execute(body);

    return ResponseEntity.ok().body(new UserResponseDTO(updatedUser));
  }
}
