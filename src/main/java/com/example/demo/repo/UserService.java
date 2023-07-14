package com.example.demo.repo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User u) {
    var user = userRepository.save(u);
    return user;
  }

  @Transactional
  public void changeUsername(Integer id, String newUsername) {
    var u = userRepository.findById(id);
    if (u.isEmpty()) {
      throw new IllegalArgumentException("Given userId does not exist");
    }
    var user = u.get();
    user.setUsername(newUsername);
  }
}
