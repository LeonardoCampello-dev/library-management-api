package com.librarymanagement.api.domain.repositories;

import com.librarymanagement.api.domain.entities.Book;

public interface BookRepository {

  Book save(Book book);
}
