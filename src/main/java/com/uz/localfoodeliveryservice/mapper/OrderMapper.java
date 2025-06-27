package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.OrderDto;
import com.uz.localfoodeliveryservice.entity.Order;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderDtoToOrderResponse(Order order);
    Order orderResponseToOrder(OrderDto orderRequest);
}
