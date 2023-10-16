package com.librarymanagement.api.infra.repository;

import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.repositories.LibraryRepository;

public class LibraryRepositoryStub implements LibraryRepository {

  @Override
  public Library save(Library library) {
    return library;
  }
}
