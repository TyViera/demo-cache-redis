package com.travelport.democacheredis.controller;

import com.travelport.democacheredis.model.User;
import com.travelport.democacheredis.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> listAll() {
    return userService.getAll();
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return userService.create(user);
  }

}
