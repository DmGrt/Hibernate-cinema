package com.spring.cinema.controllers;

import com.spring.cinema.models.Ticket;
import com.spring.cinema.models.User;
import com.spring.cinema.models.dto.order.OrderDtoMapper;
import com.spring.cinema.models.dto.order.OrderResponseDto;
import com.spring.cinema.service.OrderService;
import com.spring.cinema.service.ShoppingCartService;
import com.spring.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderDtoMapper orderMapper;
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderDtoMapper orderMapper, OrderService orderService,
                           UserService userService, ShoppingCartService shoppingCartService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        User user = userService.getById(userId);
        List<Ticket> tickets = shoppingCartService.getByUser(user).getTickets();
        orderService.completeOrder(tickets, user);
    }

    @GetMapping("/by-userId")
    public List<OrderResponseDto> getOrderByUserId(@RequestParam Long userId) {
        return orderService.getOrderHistory(userService.getById(userId)).stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
