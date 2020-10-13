package com.dmgrt.cinema.service;

import com.dmgrt.cinema.models.Order;
import com.dmgrt.cinema.models.Ticket;
import com.dmgrt.cinema.models.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(List<Ticket> tickets, User user);

    List<Order> getOrderHistory(User user);
}
