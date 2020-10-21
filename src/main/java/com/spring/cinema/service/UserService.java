package com.spring.cinema.service;

import com.spring.cinema.models.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
