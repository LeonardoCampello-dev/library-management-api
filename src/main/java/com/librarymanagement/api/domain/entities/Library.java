package com.librarymanagement.api.domain.entities;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Library {

  private UUID id;
  private String name;
  private User owner;
  private List<Book> books;

  public Library(
      String libraryName,
      User user
  ) {
    this.id = UUID.randomUUID();
    this.owner = user;
    this.name = libraryName;
  }
}
