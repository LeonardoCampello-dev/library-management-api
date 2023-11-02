package com.librarymanagement.api.infra.jpa.book;

import com.librarymanagement.api.domain.entities.Book;
import com.librarymanagement.api.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BookRepositoryImpl implements BookRepository {
  @Autowired
  JpaBookRepository jpaBookRepository;
  @Autowired
  BookMapper bookMapper;

  @Override
  public Book findById(UUID id) {
    var result = jpaBookRepository.findById(id);

    return result.map(bookUserEntity -> bookMapper.toDomain(bookUserEntity))
                 .orElse(null);
  }

  @Override
  public Book save(Book book) {

    var result = jpaBookRepository.save(bookMapper.toEntity(book));

    return bookMapper.toDomain(result);
  }

  @Override
  public void deleteById(UUID id) {
    jpaBookRepository.deleteById(id);
  }
}
