package com.librarymanagement.api.ui.controller.dto.book;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;

import java.util.UUID;

public record BookResponseDTO(
        UUID id,
        String title,
        String author,
        String publisher,
        Integer publicationYear,
        Category category,
        ReadingStatus readingStatus
) {
  public BookResponseDTO(Book book) {
    this(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getPublisher(),
            book.getPublicationYear(),
            book.getCategory(),
            book.getReadingStatus()
    );
  }
}
