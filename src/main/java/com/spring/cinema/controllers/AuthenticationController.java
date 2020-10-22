package com.spring.cinema.controllers;

import com.spring.cinema.models.dto.user.UserRegistrationDto;
import com.spring.cinema.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    private void register(@RequestBody UserRegistrationDto userRegistrationDto) {
        authenticationService.register(
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
    }
}
