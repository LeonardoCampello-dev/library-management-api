package com.librarymanagement.api.application.usecase.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.javafaker.Faker;
import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.infra.repository.LibraryRepositoryStub;
import com.librarymanagement.api.infra.repository.UserRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.library.CreateLibraryRequestDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateLibraryUseCaseTest {

  @Test
  @DisplayName("should be able to create a library")
  public void testCreate() {
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

    CreateLibraryUseCase useCase = new CreateLibraryUseCase(
        new LibraryRepositoryStub(),
        userRepo
    );

    var libraryName = faker.lorem().word();

    CreateLibraryRequestDTO dto = new CreateLibraryRequestDTO(
        libraryName,
        userId
    );

    Library library = useCase.execute(dto);

    assertThat(library.getName()).isEqualTo(libraryName);
  }

  @Test
  @DisplayName("should throw an exception when the user is not found")
  public void testUserNotFound() {
    Faker faker = new Faker();

    CreateLibraryUseCase useCase = new CreateLibraryUseCase(
        new LibraryRepositoryStub(),
        new UserRepositoryStub()
    );

    CreateLibraryRequestDTO dto = new CreateLibraryRequestDTO(
        faker.lorem().word(),
        UUID.randomUUID()
    );

    assertThrows(
        UserNotFoundException.class,
        () -> useCase.execute(dto)
    );
  }
}
