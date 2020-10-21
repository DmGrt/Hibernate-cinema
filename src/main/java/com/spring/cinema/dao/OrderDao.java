package com.spring.cinema.dao;

import com.spring.cinema.models.Order;
import com.spring.cinema.models.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrderHistory(User user);
}
