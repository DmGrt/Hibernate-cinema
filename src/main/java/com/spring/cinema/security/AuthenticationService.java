package com.spring.cinema.security;

import com.spring.cinema.exceptions.AuthenticationException;
import com.spring.cinema.models.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
