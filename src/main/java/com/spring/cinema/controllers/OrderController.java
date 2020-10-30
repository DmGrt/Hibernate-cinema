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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void complete(Authentication authentication) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userService.findByEmail(email).get();
        List<Ticket> tickets = shoppingCartService.getByUser(user).getTickets();
        orderService.completeOrder(tickets, user);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderByUserId(Authentication authentication) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        return orderService.getOrderHistory(userService.findByEmail(email).get()).stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
