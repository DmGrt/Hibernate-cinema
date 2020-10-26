package com.spring.cinema.dao;

import com.spring.cinema.models.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    User getById(Long id);
}
