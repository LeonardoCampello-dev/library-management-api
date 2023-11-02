package com.librarymanagement.api.infra.jpa.book;

import com.librarymanagement.api.domain.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
  public Book toDomain(JpaBookEntity entity) {
    return new Book(
            entity.getId(),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getPublisher(),
            entity.getPublicationYear(),
            entity.getCategory(),
            entity.getReadingStatus()
    );
  }

  public JpaBookEntity toEntity(Book book) {
    return new JpaBookEntity(
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
