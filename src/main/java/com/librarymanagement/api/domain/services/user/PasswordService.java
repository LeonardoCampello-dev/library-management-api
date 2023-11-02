package com.librarymanagement.api.domain.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

  @Autowired
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public PasswordService(BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public String encode(String password) {
    return bCryptPasswordEncoder.encode(password);
  }
}
