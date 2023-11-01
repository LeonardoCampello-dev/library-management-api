package com.librarymanagement.api.domain.exceptions;

public class BookNotFoundException extends
    RuntimeException {
  public BookNotFoundException() {
    super("book not found");
  }
}
