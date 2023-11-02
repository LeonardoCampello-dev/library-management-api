package com.librarymanagement.api.domain.repositories;

import com.librarymanagement.api.domain.entities.Book;
import java.util.UUID;

public interface BookRepository {
  Book findById(UUID id);

  Book save(Book book);

  void deleteById(UUID id);
}
