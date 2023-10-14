package com.librarymanagement.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReadingStatus {
  READ("Read"),
  READING("Reading"),
  NEXT_READING("Next Reading"),
  UNREAD("Unread");

  private final String description;
}
