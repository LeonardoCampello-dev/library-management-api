package com.librarymanagement.api.ui.controller;

import com.librarymanagement.api.application.usecase.book.CreateBookUseCase;
import com.librarymanagement.api.application.usecase.book.DeleteBookUseCase;
import com.librarymanagement.api.application.usecase.book.GetBookByIdUseCase;
import com.librarymanagement.api.application.usecase.book.UpdateBookUseCase;
import com.librarymanagement.api.ui.controller.dto.book.BookResponseDTO;
import com.librarymanagement.api.ui.controller.dto.book.CreateBookRequestDTO;
import com.librarymanagement.api.ui.controller.dto.book.UpdateBookRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
  private final GetBookByIdUseCase getBookByIdUseCase;
  private final CreateBookUseCase createBookUseCase;
  private final UpdateBookUseCase updateBookUseCase;
  private final DeleteBookUseCase deleteBookUseCase;

  @Autowired
  public BookController(
          GetBookByIdUseCase getBookByIdUseCase,
          CreateBookUseCase createBookUseCase,
          UpdateBookUseCase updateBookUseCase,
          DeleteBookUseCase deleteBookUseCase
  ) {
    this.getBookByIdUseCase = getBookByIdUseCase;
    this.createBookUseCase = createBookUseCase;
    this.updateBookUseCase = updateBookUseCase;
    this.deleteBookUseCase = deleteBookUseCase;
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookResponseDTO> getBookById(@PathVariable UUID id) {
    var book = getBookByIdUseCase.execute(id);

    return ResponseEntity.ok()
                         .body(new BookResponseDTO(book));
  }

  @PostMapping
  @Transactional
  public ResponseEntity<BookResponseDTO> create(
          @RequestBody
          CreateBookRequestDTO dto
  ) {
    var createdBook = createBookUseCase.execute(dto);

    var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                              .path("/{id}")
                                              .buildAndExpand(createdBook.getId())
                                              .toUri();

    return ResponseEntity.created(location)
                         .body(new BookResponseDTO(createdBook));
  }

  @PatchMapping("/{id}")
  @Transactional
  public ResponseEntity<BookResponseDTO> update(
          @RequestBody
          UpdateBookRequestDTO dto,
          @PathVariable UUID id
  ) {
    var updatedBook = updateBookUseCase.execute(
            dto,
            id
    );

    return ResponseEntity.ok()
                         .body(new BookResponseDTO(updatedBook));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    deleteBookUseCase.execute(id);

    return ResponseEntity.noContent()
                         .build();
  }
}
