package com.librarymanagement.api.infra.jpa.user;

import com.librarymanagement.api.domain.entities.User;
import com.librarymanagement.api.domain.repositories.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private JpaUserRepository jpaUserRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public User findById(UUID id) {
    var result = jpaUserRepository.findById(id);

    return result.map(jpaUserEntity -> userMapper.toDomain(jpaUserEntity)).orElse(null);
  }

  @Override
  public User save(User user) {
    var result = jpaUserRepository.save(userMapper.toEntity(user));

    return userMapper.toDomain(result);
  }

  @Override
  public Boolean existsByUsername(String username) {
    return jpaUserRepository.existsByUsername(username);
  }
}
