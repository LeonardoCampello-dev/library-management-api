package com.librarymanagement.api.infra.jpa.book;

import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "Book")
@Table(name = "books")

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JpaBookEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String author;
  @Column(nullable = false)
  private String publisher;
  @Column(nullable = false)
  private Integer publicationYear;
  @Column(nullable = false)
  private Category category;
  @Column(nullable = false)
  private ReadingStatus readingStatus;
}
