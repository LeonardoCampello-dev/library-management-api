package com.librarymanagement.api.application.usecase.book;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.exceptions.BookNotFoundException;
import com.librarymanagement.api.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetBookByIdUseCase {
  private final BookRepository bookRepo;

  @Autowired
  public GetBookByIdUseCase(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public Book execute(UUID bookId) {
    var book = bookRepo.findById(bookId);

    if (book == null) throw new BookNotFoundException();

    return book;
  }
}
