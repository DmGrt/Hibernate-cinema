package com.spring.cinema.security;

import com.spring.cinema.models.User;

public interface AuthenticationService {
    User register(String email, String password);
}
