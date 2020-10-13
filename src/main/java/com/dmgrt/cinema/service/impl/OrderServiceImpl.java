package com.dmgrt.cinema.service.impl;

import com.dmgrt.cinema.dao.OrderDao;
import com.dmgrt.cinema.lib.Inject;
import com.dmgrt.cinema.lib.Service;
import com.dmgrt.cinema.models.Order;
import com.dmgrt.cinema.models.Ticket;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.service.OrderService;
import com.dmgrt.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(List<Ticket> tickets, User user) {
        Order order = new Order();
        order.setTickets(new ArrayList<>(tickets));
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
