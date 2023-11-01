package com.librarymanagement.api.application.usecase.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.javafaker.Faker;
import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import com.librarymanagement.api.domain.exceptions.BookNotFoundException;
import com.librarymanagement.api.infra.repository.BookRepositoryStub;
import com.librarymanagement.api.ui.controller.dto.book.UpdateBookRequestDTO;
import java.time.Year;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateBookUseCaseTest {

  @Test
  @DisplayName("should be able to update book")
  public void testUpdate() {
    Faker faker = new Faker();
    Random random = new Random();

    var bookRepo = new BookRepositoryStub();

    var bookId = UUID.randomUUID();

    bookRepo.addBook(new Book(
        bookId,
        faker.lorem().word(),
        faker.name().fullName(),
        faker.company()
            .name(),
        2000,
        Category.OTHER,
        ReadingStatus.UNREAD
    ));

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

    UpdateBookRequestDTO dto = new UpdateBookRequestDTO(
        title,
        author,
        publisher,
        randomYear,
        randomCategory,
        randomReadingStatus
    );

    UpdateBookUseCase useCase = new UpdateBookUseCase(bookRepo);

    var updatedBook = useCase.execute(dto, bookId);

    assertThat(updatedBook.getTitle()).isEqualTo(title);
    assertThat(updatedBook.getAuthor()).isEqualTo(author);
    assertThat(updatedBook.getPublisher()).isEqualTo(publisher);
    assertThat(updatedBook.getPublicationYear()).isEqualTo(randomYear);
    assertThat(updatedBook.getCategory()).isEqualTo(randomCategory);
    assertThat(updatedBook.getReadingStatus()).isEqualTo(randomReadingStatus);
  }

  @Test
  @DisplayName("should throw an exception when the book is not found")
  public void testBookNotFound() {
    UpdateBookUseCase useCase = new UpdateBookUseCase(
        new BookRepositoryStub()
    );

    UpdateBookRequestDTO dto = new UpdateBookRequestDTO(
        null,
        null,
        null,
        null,
        null,
        null
    );

    assertThrows(
        BookNotFoundException.class,
        () -> useCase.execute(
            dto,
            UUID.randomUUID()
        )
    );
  }
}