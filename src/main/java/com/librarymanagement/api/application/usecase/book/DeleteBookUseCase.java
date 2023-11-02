package com.librarymanagement.api.application.usecase.book;

import com.librarymanagement.api.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteBookUseCase {
  private final BookRepository bookRepo;

  @Autowired
  public DeleteBookUseCase(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public void execute(UUID bookId) {
    this.bookRepo.deleteById(bookId);
  }
}
