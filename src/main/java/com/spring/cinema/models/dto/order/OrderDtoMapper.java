package com.spring.cinema.models.dto.order;

import com.spring.cinema.models.Order;
import com.spring.cinema.models.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setTicketIds(order.getTickets()
                .stream().map(Ticket::getId)
                .collect(Collectors.toList()));
        orderDto.setOrderDate(order.getOrderDate().toString());
        return orderDto;
    }
}
