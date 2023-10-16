package com.librarymanagement.api.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() {
    super("user not found");
  }
}
