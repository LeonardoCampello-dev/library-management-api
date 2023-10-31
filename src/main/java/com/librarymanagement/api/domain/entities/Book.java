package com.librarymanagement.api.domain.entities;

import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book {

  private UUID id;
  private String title;
  private String author;
  private String publisher;
  private Category category;
  private ReadingStatus readingStatus = ReadingStatus.UNREAD;
}
