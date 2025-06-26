package com.uz.localfoodeliveryservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Integer totalPrice;
    private String status;
    private Instant createdAt;
    private List<OrderItemResponse> items;
}



