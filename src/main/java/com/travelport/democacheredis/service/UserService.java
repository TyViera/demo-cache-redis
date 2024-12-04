package com.travelport.democacheredis.service;

import com.travelport.democacheredis.model.User;
import java.util.List;

public interface UserService {
  List<User> getAll();

  User create(User user);
}
