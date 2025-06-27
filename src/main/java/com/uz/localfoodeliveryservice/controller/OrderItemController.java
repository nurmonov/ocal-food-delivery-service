package com.uz.localfoodeliveryservice.controller;


import com.uz.localfoodeliveryservice.dto.OrderItemDto;
import com.uz.localfoodeliveryservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAll() {
        return ResponseEntity.ok(orderItemService.getAll());
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> create(@RequestBody OrderItemDto dto) {
        return ResponseEntity.ok(orderItemService.create(dto));
    }
}

