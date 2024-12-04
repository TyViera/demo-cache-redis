package com.travelport.democacheredis.repository;

import com.travelport.democacheredis.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final CacheManager cacheManager;
  private final List<User> data = new ArrayList<>();

  public UserRepositoryImpl(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }

  @Override
  @Cacheable(cacheNames = "userList")
  public List<User> getAll() {
    System.out.println("Getting all users");
    return data;
  }

  @Override
  @CachePut(cacheNames = "users", key = "#user.id")//spel - spring expression language
  @CacheEvict(cacheNames = "userList")
  public User create(User user) {

    cacheManager.getCache("users").put(user.getId(), user);
    cacheManager.getCache("users").invalidate();

    data.add(user);
    return user;
  }
}
