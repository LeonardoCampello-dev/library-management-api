package com.librarymanagement.api.infra.persistence.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user")

@AllArgsConstructor
@Getter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column
  private String username;
  @Column
  private String email;
  @Column
  private String password;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private LocalDateTime registrationDate;
}
