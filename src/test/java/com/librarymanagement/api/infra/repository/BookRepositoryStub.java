package com.librarymanagement.api.infra.repository;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.repositories.BookRepository;

public class BookRepositoryStub implements BookRepository {

  @Override
  public Book save(Book book) {
    return book;
  }
}
