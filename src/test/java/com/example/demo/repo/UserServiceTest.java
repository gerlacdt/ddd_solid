package com.example.demo.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

  @Autowired UserService sut;

  @Test
  public void save_validUser_userSaved() {
    User u = defaultUser();
    User actual = sut.createUser(u);

    System.out.println("user: " + actual);
  }

  private User defaultUser() {
    return new User("username", "email");
  }
}
