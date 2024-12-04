package com.travelport.democacheredis.service;

import com.travelport.democacheredis.model.User;
import com.travelport.democacheredis.repository.UserRepository;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Cacheable(cacheNames = "userList")
  public List<User> getAll() {
    return userRepository.getAll();
  }

  @Override
  public User create(User user) {
    return userRepository.create(user);
  }
}
