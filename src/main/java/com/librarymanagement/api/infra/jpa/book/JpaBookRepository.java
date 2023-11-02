package com.librarymanagement.api.infra.jpa.book;

import com.librarymanagement.api.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface JpaBookRepository extends JpaRepository<JpaBookEntity, UUID> {
}
