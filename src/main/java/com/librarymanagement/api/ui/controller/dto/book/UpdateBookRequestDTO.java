package com.librarymanagement.api.ui.controller.dto.book;

import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;

public record UpdateBookRequestDTO(
    String title,
    String author,
    String publisher,
    Integer publicationYear,
    Category category,
    ReadingStatus readingStatus
) {

}
