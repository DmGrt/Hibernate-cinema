package com.dmgrt.cinema.security.impl;

import com.dmgrt.cinema.exceptions.AuthenticationException;
import com.dmgrt.cinema.lib.Inject;
import com.dmgrt.cinema.lib.Service;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.security.AuthenticationService;
import com.dmgrt.cinema.service.UserService;
import com.dmgrt.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent() && user.get().getPassword()
                .equals(HashUtil.hashPassword(password, user.get().getSalt()))) {
            return user.get();
        }
        throw new AuthenticationException("Incorrect username or password!");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user = userService.add(user);
        return user;
    }
}
