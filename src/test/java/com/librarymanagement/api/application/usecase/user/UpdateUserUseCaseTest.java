package com.librarymanagement.api.application.usecase.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.javafaker.Faker;
import com.librarymanagement.api.application.usecase.library.CreateLibraryUseCase;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.infra.repository.LibraryRepositoryStub;
import com.librarymanagement.api.infra.repository.UserRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.CreateLibraryRequestDTO;
import com.librarymanagement.api.ui.controller.dto.UpdateUserRequestDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateUserUseCaseTest {

  @Test
  @DisplayName("should be able to update user")
  public void testUpdate() {
    Faker faker = new Faker();

    var userRepo = new UserRepositoryStub();

    var userId = UUID.randomUUID();

    userRepo.addUser(new User(
        userId,
        faker.name().username(),
        faker.internet().emailAddress(),
        faker.internet().password(),
        faker.name().firstName(),
        faker.name().lastName(),
        LocalDateTime.now()
    ));

    UpdateUserUseCase useCase = new UpdateUserUseCase(userRepo);

    var newUsername = faker.name().username();

    UpdateUserRequestDTO dto = new UpdateUserRequestDTO(
        userId,
        faker.name().firstName(),
        faker.name().lastName(),
        newUsername
    );

    var updatedUser = useCase.execute(dto);

    assertThat(updatedUser.getUsername()).isEqualTo(newUsername);
  }

  @Test
  @DisplayName("should throw an exception when the user is not found")
  public void testUserNotFound() {
    UpdateUserUseCase useCase = new UpdateUserUseCase(
        new UserRepositoryStub()
    );

    UpdateUserRequestDTO dto = new UpdateUserRequestDTO(
        UUID.randomUUID(),
        null,
        null,
        null
    );

    assertThrows(
        UserNotFoundException.class,
        () -> useCase.execute(dto)
    );
  }
}
