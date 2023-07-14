package com.example.demo.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

  @Autowired UserService sut;

  @Autowired UserRepository userRepository;

  @Test
  public void save_validUser_userSaved() {
    User u = defaultUser();
    User actual = sut.createUser(u);

    assertNotNull(actual.getId());
  }

  @Test
  public void changeUsername_validName_usernamedChanged() {
    User user = sut.createUser(defaultUser());

    sut.changeUsername(user.getId(), "newUsername");

    var actual = userRepository.findById(user.getId());
    var expected = "newUsername";
    assertEquals(expected, actual.get().getUsername());
  }

  private User defaultUser() {
    return new User("username", "email");
  }
}
