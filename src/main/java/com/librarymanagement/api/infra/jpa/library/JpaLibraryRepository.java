package com.librarymanagement.api.infra.jpa.library;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLibraryRepository extends JpaRepository<JpaLibraryEntity, UUID> {

}
