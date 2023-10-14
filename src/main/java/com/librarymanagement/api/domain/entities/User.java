package com.librarymanagement.api.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

  private UUID id;
  private String username;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private LocalDateTime registrationDate;

}
