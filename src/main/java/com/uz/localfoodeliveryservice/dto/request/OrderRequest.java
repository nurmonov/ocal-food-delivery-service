package com.uz.localfoodeliveryservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Integer userId;
    private Integer restaurantId;
    private List<OrderItemRequest> items;
    private String paymentType;
}
