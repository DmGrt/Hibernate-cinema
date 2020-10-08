package com.dmgrt.cinema.security;

import com.dmgrt.cinema.exceptions.AuthenticationException;
import com.dmgrt.cinema.models.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
