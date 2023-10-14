package com.librarymanagement.api.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonalRating {
  private UUID id;
  private Book book;
  private Integer rating;
  private String comments;
  private LocalDateTime date;


}
