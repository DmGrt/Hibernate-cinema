package com.spring.cinema.controllers;

import com.spring.cinema.models.MovieSession;
import com.spring.cinema.models.User;
import com.spring.cinema.models.dto.shoppingcart.ShoppingCartDtoMapper;
import com.spring.cinema.models.dto.shoppingcart.ShoppingCartResponseDto;
import com.spring.cinema.service.MovieSessionService;
import com.spring.cinema.service.ShoppingCartService;
import com.spring.cinema.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartDtoMapper shoppingCartMapping;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCartController(
            ShoppingCartDtoMapper shoppingCartMapping, ShoppingCartService shoppingCartService,
            MovieSessionService movieSessionService, UserService userService) {
        this.shoppingCartMapping = shoppingCartMapping;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PostMapping("/movie-session")
    public void addMovieSession(Authentication authentication, @RequestParam Long movieSessionId) {
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userService.findByEmail(email).get();
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userService.findByEmail(email).get();
        return shoppingCartMapping
                .mapToDto(shoppingCartService.getByUser(user));
    }
}
