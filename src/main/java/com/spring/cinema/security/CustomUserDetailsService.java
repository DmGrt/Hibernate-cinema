package com.spring.cinema.security;

import com.spring.cinema.models.User;
import com.spring.cinema.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByEmail(email);
        User user;
        UserBuilder builder;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(user.getPassword());
            builder.roles(user.getRoles().stream().map(role -> role.getRoleName().toString())
                    .toArray(String[]::new));
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
        return builder.build();
    }
}
