package com.spring.cinema.service;

import com.spring.cinema.models.MovieSession;
import com.spring.cinema.models.ShoppingCart;
import com.spring.cinema.models.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
