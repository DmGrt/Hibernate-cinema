package com.dmgrt.cinema.service;

import com.dmgrt.cinema.models.MovieSession;
import com.dmgrt.cinema.models.ShoppingCart;
import com.dmgrt.cinema.models.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
