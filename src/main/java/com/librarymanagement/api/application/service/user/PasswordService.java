package com.librarymanagement.api.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public String encode(String password) {
    return bCryptPasswordEncoder.encode(password);
  }

  public boolean matches(
      String password,
      String hash
  ) {
    return bCryptPasswordEncoder.matches(
        password,
        hash
    );
  }
}
