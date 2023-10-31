package com.librarymanagement.api.application.usecase.book;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.repositories.BookRepository;
import com.librarymanagement.api.ui.controller.dto.book.CreateBookRequestDTO;

public class BookCreateUseCase {

  private final BookRepository bookRepo;

  public BookCreateUseCase(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public Book execute(CreateBookRequestDTO dto) {
    var book = new Book(
        null,
        dto.title(),
        dto.author(),
        dto.publisher(),
        dto.category(),
        dto.readingStatus()
    );

    return bookRepo.save(book);
  }
}
