package com.example.demo.repo;

import com.google.common.base.Preconditions;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  private User() {}

  public User(String username, String email) {
    Preconditions.checkNotNull(username, "username must not be null");
    Preconditions.checkNotNull(email, "email must not be null");
    this.username = username;
    this.email = email;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column private String username;

  @Column private String email;

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String toString() {
    return String.format("[id: %d username: %s email: %s]", this.id, this.username, this.email);
  }
}
