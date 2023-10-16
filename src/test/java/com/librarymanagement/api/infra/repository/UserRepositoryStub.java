package com.librarymanagement.api.infra.repository;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.repositories.UserRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryStub implements UserRepository {

  private final Map<UUID, User> users = new HashMap<>();

  public void addUser(User user) {
    users.put(
        user.getId(),
        user
    );
  }

  @Override
  public User findById(UUID id) {
    return users.get(id);
  }
}
