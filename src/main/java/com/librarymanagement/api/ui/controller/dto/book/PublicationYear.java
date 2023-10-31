package com.librarymanagement.api.ui.controller.dto.book;

import com.librarymanagement.api.ui.controller.dto.book.CreateBookRequestDTO.PublicationYearValidator;
import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PublicationYearValidator.class)
@interface PublicationYear {

}
