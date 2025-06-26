package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.OrderRequest;
import com.uz.localfoodeliveryservice.dto.response.OrderResponse;
import com.uz.localfoodeliveryservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse orderDtoToOrderResponse(Order order);
    Order orderResponseToOrder(OrderRequest orderRequest);
}
