package com.librarymanagement.api.domain.entities;

import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString()
public class Book {

  private UUID id;
  private String title;
  private String author;
  private String publisher;
  private Integer publicationYear;
  private Category category;
  private ReadingStatus readingStatus = ReadingStatus.UNREAD;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setPublicationYear(Integer publicationYear) {
    this.publicationYear = publicationYear;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public void setReadingStatus(ReadingStatus readingStatus) {
    this.readingStatus = readingStatus;
  }
}
