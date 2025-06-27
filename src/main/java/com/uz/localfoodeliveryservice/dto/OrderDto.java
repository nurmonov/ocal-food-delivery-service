package com.uz.localfoodeliveryservice.dto;

import com.uz.localfoodeliveryservice.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Integer totalPrice;
    private OrderStatus status;
    private Instant createdAt;


}
