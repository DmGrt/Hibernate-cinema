package com.dmgrt.cinema.dao;

import com.dmgrt.cinema.models.ShoppingCart;
import com.dmgrt.cinema.models.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
