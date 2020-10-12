package com.dmgrt.cinema.dao;

import com.dmgrt.cinema.models.Order;
import com.dmgrt.cinema.models.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrderHistory(User user);
}
