package com.spring.cinema.models.dto.shoppingcart;

import com.spring.cinema.models.ShoppingCart;
import com.spring.cinema.models.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoMapper {
    public ShoppingCartResponseDto mapToDto(ShoppingCart order) {
        ShoppingCartResponseDto cartDto = new ShoppingCartResponseDto();
        cartDto.setId(order.getId());
        cartDto.setTicketIds(order.getTickets()
                .stream().map(Ticket::getId)
                .collect(Collectors.toList()));
        cartDto.setUserId(order.getUser().getId());
        return cartDto;
    }
}
