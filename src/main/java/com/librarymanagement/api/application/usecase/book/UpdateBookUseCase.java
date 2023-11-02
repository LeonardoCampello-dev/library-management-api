package com.librarymanagement.api.application.usecase.book;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.exceptions.BookNotFoundException;
import com.librarymanagement.api.domain.repositories.BookRepository;
import com.librarymanagement.api.ui.controller.dto.book.UpdateBookRequestDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookUseCase {

  private final BookRepository bookRepo;

  @Autowired
  public UpdateBookUseCase(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public Book execute(
      UpdateBookRequestDTO dto,
      UUID bookId
  ) {
    Book book = bookRepo.findById(bookId);

    if (book == null) {
      throw new BookNotFoundException();
    }

    if (dto.title() != null) {
      book.setTitle(dto.title());
    }

    if (dto.author() != null) {
      book.setAuthor(dto.author());
    }

    if (dto.publisher() != null) {
      book.setPublisher(dto.publisher());
    }

    if (dto.category() != null) {
      book.setCategory(dto.category());
    }

    if (dto.publicationYear() != null) {
      book.setPublicationYear(dto.publicationYear());
    }

    if (dto.readingStatus() != null) {
      book.setReadingStatus(dto.readingStatus());
    }

    return bookRepo.save(book);
  }
}
