package com.librarymanagement.api.infra.jpa.library;

import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
  @Autowired
  private JpaLibraryRepository jpaLibraryRepository;

  @Override
  public Library save(Library library) {
    return null;
  }
}
