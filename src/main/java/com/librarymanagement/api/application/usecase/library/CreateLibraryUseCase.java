package com.librarymanagement.api.application.usecase.library;

import com.librarymanagement.api.domain.entities.Library;
import com.librarymanagement.api.domain.repository.LibraryRepository;
import com.librarymanagement.api.domain.repository.UserRepository;
import com.librarymanagement.api.ui.controller.dto.CreateLibraryRequestDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

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
      throw new RuntimeException("user not found");
    }

    Library library = new Library(dto.libraryName(), user);

    return libraryRepo.save(library);
  }
}
