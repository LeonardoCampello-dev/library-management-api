package com.librarymanagement.api.domain.repositories;

import com.librarymanagement.api.domain.entities.User;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  User findById(UUID id);

  User save(User user);

  Boolean existsByUsername(String username);
}
