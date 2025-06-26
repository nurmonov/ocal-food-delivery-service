package com.uz.localfoodeliveryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Integer totalPrice;
    private String status; // e.g. NEW, PAID, DELIVERED, CANCELLED
    private LocalDateTime createdAt;

    private List<OrderItemDto> items; // optional: OrderItem list
}

