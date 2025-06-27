package com.uz.localfoodeliveryservice.service;


import com.uz.localfoodeliveryservice.dto.OrderDto;
import com.uz.localfoodeliveryservice.entity.Order;
import com.uz.localfoodeliveryservice.entity.Restaurant;
import com.uz.localfoodeliveryservice.entity.User;
import com.uz.localfoodeliveryservice.repository.OrderRepository;
import com.uz.localfoodeliveryservice.repository.RestaurantRepository;
import com.uz.localfoodeliveryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto getById(Integer id) {
        return toDto(orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found")));
    }

    public OrderDto create(OrderDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Order order = toEntity(dto);
        order.setUser(user);
        order.setRestaurant(restaurant);
        return toDto(orderRepository.save(order));
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    private OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getRestaurant().getId(),
                order.getTotalPrice(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

    private Order toEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalPrice(dto.getTotalPrice());
        order.setStatus(dto.getStatus());
        order.setCreatedAt(dto.getCreatedAt());
        return order;
    }
}
