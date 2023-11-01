package com.librarymanagement.api.application.usecase.book;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import com.librarymanagement.api.infra.repository.BookRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.book.CreateBookRequestDTO;
import java.time.Year;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookCreateUseCaseTest {

  @Test
  @DisplayName("should be able to create book")
  public void testCreate() {
    Faker faker = new Faker();
    Random random = new Random();

    BookCreateUseCase useCase = new BookCreateUseCase(new BookRepositoryStub());

    var title = faker.lorem().word();
    var author = faker.name().fullName();
    var publisher = faker.company().name();

    var currentYear = Year.now().getValue();
    var lowerYearLimit = 1900;
    int randomYear = random.nextInt(currentYear - lowerYearLimit + 1) + lowerYearLimit;

    var allReadingStatus = ReadingStatus.values();
    var allCategories = Category.values();
    var randomReadingStatus = allReadingStatus[random.nextInt(allReadingStatus.length)];
    var randomCategory = allCategories[random.nextInt(allCategories.length)];

    CreateBookRequestDTO dto = new CreateBookRequestDTO(
        title,
        author,
        publisher,
        randomCategory,
        randomYear,
        randomReadingStatus
    );

    var book = useCase.execute(dto);

    assertThat(book.getTitle()).isEqualTo(title);
    assertThat(book.getAuthor()).isEqualTo(author);
    assertThat(book.getPublisher()).isEqualTo(publisher);
    assertThat(book.getCategory()).isEqualTo(randomCategory);
    assertThat(book.getReadingStatus()).isEqualTo(randomReadingStatus);
  }
}