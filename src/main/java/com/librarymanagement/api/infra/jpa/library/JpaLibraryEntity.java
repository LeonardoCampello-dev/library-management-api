package com.librarymanagement.api.infra.jpa.library;

import com.librarymanagement.api.infra.jpa.user.JpaUserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Library")
@Table(name = "libraries")

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JpaLibraryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false)
  private String name;
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private JpaUserEntity owner;
}
