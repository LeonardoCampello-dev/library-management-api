package com.librarymanagement.api.domain.exceptions;

public class UsernameAlreadyExistsException extends
    RuntimeException {

  public UsernameAlreadyExistsException(String username) {
    super("username " + username + " already exists");
  }
}
