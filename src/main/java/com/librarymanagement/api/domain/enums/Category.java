package com.librarymanagement.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
  ROMANCE("Romance"),
  SCIENCE_FICTION("Science Fiction"),
  MYSTERY("Mystery"),
  FANTASY("Fantasy"),
  NON_FICTION("Non-Fiction"),
  BIOGRAPHY("Biography"),
  HISTORY("History"),
  SELF_HELP("Self-Help"),
  POETRY("Poetry"),
  OTHER("Other");


  private final String description;
}
