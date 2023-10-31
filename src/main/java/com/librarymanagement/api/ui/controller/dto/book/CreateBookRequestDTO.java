package com.librarymanagement.api.ui.controller.dto.book;

import com.librarymanagement.api.domain.enums.Category;
import com.librarymanagement.api.domain.enums.ReadingStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;

public record CreateBookRequestDTO(
    @NotBlank
    String title,
    @NotBlank
    String author,
    @NotBlank
    String publisher,
    @NotBlank
    Category category,
    @PublicationYear
    Integer publicationYear,
    ReadingStatus readingStatus
) {

  public static class PublicationYearValidator implements
      ConstraintValidator<PublicationYear, Integer> {

    @Override
    public boolean isValid(
        Integer year,
        ConstraintValidatorContext constraintValidatorContext
    ) {
      var currentYear = Year.from(new Date().toInstant().atZone(ZoneId.systemDefault()))
          .getValue();

      if (year == null) {
        return false;
      } else if (year < 1000) {
        return false;
      } else {
        return year > currentYear;
      }
    }
  }
}


