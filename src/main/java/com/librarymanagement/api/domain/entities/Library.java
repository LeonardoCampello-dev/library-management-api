package com.librarymanagement.api.domain.entities;

import java.util.List;
import java.util.UUID;

public class Library {

  private UUID id;
  private String name;
  private User owner;
  private List<Book> books;
}
