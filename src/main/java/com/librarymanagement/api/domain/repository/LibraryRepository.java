package com.librarymanagement.api.domain.repository;

import com.librarymanagement.api.domain.entities.Library;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository {

  Library save(Library library);
}
