package com.spring.cinema.dao;

import com.spring.cinema.models.ShoppingCart;
import com.spring.cinema.models.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
