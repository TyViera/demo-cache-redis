package com.travelport.democacheredis.repository;

import com.travelport.democacheredis.model.User;
import java.util.List;

public interface UserRepository {
  List<User> getAll();

  User create(User user);
}
