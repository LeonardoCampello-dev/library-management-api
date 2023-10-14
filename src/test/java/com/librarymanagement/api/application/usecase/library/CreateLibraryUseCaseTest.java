package com.librarymanagement.api.application.usecase.library;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.javafaker.Faker;
import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.infra.repository.LibraryRepositoryStub;
import com.librarymanagement.api.infra.repository.UserRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.CreateLibraryRequestDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class CreateLibraryUseCaseTest {

  @Test
  public void testCreateLibraryUseCase() {
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

    CreateLibraryRequestDTO dto = new CreateLibraryRequestDTO(
        "My library",
        userId
    );

    Library library = useCase.execute(dto);

    assertNotNull(library);
  }
}
