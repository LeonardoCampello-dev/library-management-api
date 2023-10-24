package com.librarymanagement.api.infra.jpa.user;

import com.librarymanagement.api.infra.jpa.library.JpaLibraryEntity;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Table(name = "users")

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JpaUserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column()
  private LocalDateTime registrationDate;
  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<JpaLibraryEntity> libraries;
}
