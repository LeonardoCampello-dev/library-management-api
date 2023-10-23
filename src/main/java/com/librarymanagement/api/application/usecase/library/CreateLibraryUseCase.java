package com.librarymanagement.api.application.usecase.library;

import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.exceptions.UserNotFoundException;
import com.librarymanagement.api.domain.repositories.LibraryRepository;
import com.librarymanagement.api.domain.repositories.UserRepository;
import com.librarymanagement.api.ui.controller.dto.library.CreateLibraryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLibraryUseCase {

  private final LibraryRepository libraryRepo;
  private final UserRepository userRepo;

  @Autowired
  public CreateLibraryUseCase(
      LibraryRepository libraryRepo,
      UserRepository userRepo
  ) {
    this.libraryRepo = libraryRepo;
    this.userRepo = userRepo;
  }

  public Library execute(CreateLibraryRequestDTO dto) {
    var user = userRepo.findById(dto.userId());

    if (user == null) {
      throw new UserNotFoundException();
    }

    Library library = new Library(
        dto.libraryName(),
        user
    );

    return libraryRepo.save(library);
  }
}
