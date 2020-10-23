package com.spring.cinema.controllers;

import com.spring.cinema.models.dto.user.UserRegistrationDto;
import com.spring.cinema.security.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private static final Logger logger = Logger.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registration")
    private void register(@RequestBody UserRegistrationDto userRegistrationDto) {
        authenticationService.register(
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
        logger.info(userRegistrationDto.getEmail() + " is registered");
    }
}
