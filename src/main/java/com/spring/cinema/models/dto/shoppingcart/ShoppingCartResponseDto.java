package com.spring.cinema.models.dto.shoppingcart;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;
}
