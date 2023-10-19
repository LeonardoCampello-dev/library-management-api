package com.librarymanagement.api.application.usecase.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import com.librarymanagement.api.application.service.user.UsernameValidationService;
import com.librarymanagement.api.infra.repository.UserRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.CreateUserRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateUserUseCaseTest {

  @Test
  @DisplayName("should be able to create user")
  public void testCreate() {
    Faker faker = new Faker();

    var username = faker.name().username();
    var firstName = faker.name().firstName();
    var lastName = faker.name().lastName();
    var email = faker.internet().emailAddress();

    var password = faker.internet().password(
        8,
        16,
        true,
        true,
        true
    );

    var userRepo = new UserRepositoryStub();

    CreateUserUseCase useCase = new CreateUserUseCase(
        userRepo,
        new UsernameValidationService(userRepo)
    );

    CreateUserRequestDTO dto = new CreateUserRequestDTO(
        username,
        email,
        password,
        firstName,
        lastName
    );

    var user = useCase.execute(dto);

    assertThat(user.getEmail()).isEqualTo(email);
    assertThat(user.getPassword()).isEqualTo(password);
    assertThat(user.getUsername()).isEqualTo(username);
    assertThat(user.getFirstName()).isEqualTo(firstName);
    assertThat(user.getLastName()).isEqualTo(lastName);
  }
}
