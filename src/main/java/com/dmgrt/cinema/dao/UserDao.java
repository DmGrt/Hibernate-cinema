package com.dmgrt.cinema.dao;

import com.dmgrt.cinema.models.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
