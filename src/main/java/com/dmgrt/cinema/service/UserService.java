package com.dmgrt.cinema.service;

import com.dmgrt.cinema.models.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
