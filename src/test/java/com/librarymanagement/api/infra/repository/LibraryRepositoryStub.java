package com.librarymanagement.api.infra.repository;

import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.repository.LibraryRepository;

public class LibraryRepositoryStub implements LibraryRepository {

  @Override
  public Library save(Library library) {
    return library;
  }
}
