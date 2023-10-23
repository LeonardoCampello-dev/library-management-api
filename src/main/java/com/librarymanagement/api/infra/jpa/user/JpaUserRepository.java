package com.librarymanagement.api.infra.jpa.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {

  Boolean existsByUsername(String username);
}
