//package com.uz.localfoodeliveryservice;
//
//
//import com.uz.localfoodeliveryservice.dto.request.OrderItemRequest;
//import com.uz.localfoodeliveryservice.dto.response.OrderItemResponse;
//import com.uz.localfoodeliveryservice.entity.OrderItem;
//import com.uz.localfoodeliveryservice.entity.OrderItemPK;
//import com.uz.localfoodeliveryservice.mapper.OrderItemMapper;
//import com.uz.localfoodeliveryservice.repository.OrderItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class OrderItemService {
//
//    private final OrderItemRepository orderItemRepository;
//    private final OrderItemMapper orderItemMapper;
//
//    // 1. Yangi order item qo‘shish
//    public OrderItemResponse create(OrderItemRequest request) {
//        OrderItem orderItem = orderItemMapper.toEntity(request);
//
//        // composite key ni yaratamiz
//        OrderItemPK pk = new OrderItemPK(request.getOrderId(), request.getProductId());
//        orderItem.setId(pk);
//
//        OrderItem saved = orderItemRepository.save(orderItem);
//        return orderItemMapper.toDto(saved);
//    }
//
//    // 2. Barcha order itemlarni olish
//    public List<OrderItemResponse> getAll() {
//        return orderItemRepository.findAll()
//                .stream()
//                .map(orderItemMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    // 3. Bitta order itemni olish
//    public OrderItemResponse getById(Integer orderId, Integer productId) {
//        OrderItemPK id = new OrderItemPK(orderId, productId);
//        OrderItem orderItem = orderItemRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
//        return orderItemMapper.toDto(orderItem);
//    }
//
//    // 4. O‘chirish
//    public void delete(Integer orderId, Integer productId) {
//        OrderItemPK id = new OrderItemPK(orderId, productId);
//        if (!orderItemRepository.existsById(id)) {
//            throw new RuntimeException("OrderItem not found");
//        }
//        orderItemRepository.deleteById(id);
//    }
//
//    // 5. Yangilash (optional)
//    public OrderItemResponse update(OrderItemRequest request) {
//        OrderItemPK id = new OrderItemPK(request.getOrderId(), request.getProductId());
//        Optional<OrderItem> optional = orderItemRepository.findById(id);
//
//        if (optional.isEmpty()) {
//            throw new RuntimeException("OrderItem not found");
//        }
//
//        OrderItem orderItem = optional.get();
//        orderItem.setQuantity(request.getQuantity());
//        orderItem.setPrice(request.getPrice());
//
//        OrderItem saved = orderItemRepository.save(orderItem);
//        return orderItemMapper.toDto(saved);
//    }
//}
//
