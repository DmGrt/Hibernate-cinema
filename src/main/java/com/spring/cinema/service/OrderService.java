package com.spring.cinema.service;

import com.spring.cinema.models.Order;
import com.spring.cinema.models.Ticket;
import com.spring.cinema.models.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(List<Ticket> tickets, User user);

    List<Order> getOrderHistory(User user);
}
