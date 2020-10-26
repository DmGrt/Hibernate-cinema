package com.spring.cinema.models.dto.order;

import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private String orderDate;
    private List<Long> ticketIds;
}
