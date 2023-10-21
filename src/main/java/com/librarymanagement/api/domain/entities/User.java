package com.librarymanagement.api.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "password")
public class User {

  private UUID id;
  private String username;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private LocalDateTime registrationDate;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
