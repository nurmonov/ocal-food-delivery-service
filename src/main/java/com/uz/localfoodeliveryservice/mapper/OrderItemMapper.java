package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.OrderItemRequest;
import com.uz.localfoodeliveryservice.dto.response.OrderResponse;
import com.uz.localfoodeliveryservice.entity.Order;
import com.uz.localfoodeliveryservice.entity.OrderItem;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem orderDtoToOrder(OrderItemRequest orderRequest);
    OrderResponse orderToOrderResponse(OrderItem orderItem);
}
