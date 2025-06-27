package com.uz.localfoodeliveryservice.controller;


import com.uz.localfoodeliveryservice.dto.RestaurantDto;
import com.uz.localfoodeliveryservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAll() {
        return ResponseEntity.ok(restaurantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(restaurantService.getById(id));
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> create(@RequestBody RestaurantDto dto) {
        return ResponseEntity.ok(restaurantService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable Integer id, @RequestBody RestaurantDto dto) {
        return ResponseEntity.ok(restaurantService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        restaurantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

