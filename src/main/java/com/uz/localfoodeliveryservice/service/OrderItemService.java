package com.uz.localfoodeliveryservice.service;


import com.uz.localfoodeliveryservice.dto.OrderItemDto;
import com.uz.localfoodeliveryservice.entity.Order;
import com.uz.localfoodeliveryservice.entity.OrderItem;
import com.uz.localfoodeliveryservice.entity.Product;
import com.uz.localfoodeliveryservice.repository.OrderItemRepository;
import com.uz.localfoodeliveryservice.repository.OrderRepository;
import com.uz.localfoodeliveryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<OrderItemDto> getAll() {
        return orderItemRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public OrderItemDto create(OrderItemDto dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItem orderItem = toEntity(dto);
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        return toDto(orderItemRepository.save(orderItem));
    }

    private OrderItemDto toDto(OrderItem item) {
        return new OrderItemDto(
                item.getOrder().getId(),
                item.getProduct().getId(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    private OrderItem toEntity(OrderItemDto dto) {
        OrderItem item = new OrderItem();
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }
}

