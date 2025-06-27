package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.OrderItemDto;
import com.uz.localfoodeliveryservice.entity.Order;
import com.uz.localfoodeliveryservice.entity.OrderItem;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderItemMapper {


    OrderItem orderDtoToOrder(OrderItemDto orderRequest);
    OrderItemDto orderToOrderResponse(OrderItem orderItem);
}
