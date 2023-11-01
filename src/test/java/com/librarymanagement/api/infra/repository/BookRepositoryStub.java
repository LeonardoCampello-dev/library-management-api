package com.librarymanagement.api.infra.repository;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.repositories.BookRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookRepositoryStub implements BookRepository {

  private final Map<UUID, Book> books = new HashMap<>();

  public void addBook(Book book) {
    books.put(
        book.getId(),
        book
    );
  }

  @Override
  public Book findById(UUID id) {
    return books.get(id);
  }

  @Override
  public Book save(Book book) {
    return book;
  }
}
