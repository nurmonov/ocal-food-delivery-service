package com.uz.localfoodeliveryservice.service;


import com.uz.localfoodeliveryservice.dto.RestaurantDto;
import com.uz.localfoodeliveryservice.entity.Restaurant;
import com.uz.localfoodeliveryservice.entity.User;
import com.uz.localfoodeliveryservice.repository.RestaurantRepository;
import com.uz.localfoodeliveryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public List<RestaurantDto> getAll() {
        return restaurantRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RestaurantDto getById(Integer id) {
        return toDto(restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
    }

    public RestaurantDto create(RestaurantDto dto) {
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = toEntity(dto);
        restaurant.setOwner(owner);
        return toDto(restaurantRepository.save(restaurant));
    }

    public RestaurantDto update(Integer id, RestaurantDto dto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhone(dto.getPhone());
        restaurant.setLogoUrl(dto.getLogoUrl());
        restaurant.setOwner(owner);

        return toDto(restaurantRepository.save(restaurant));
    }

    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }

    private RestaurantDto toDto(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getOwner().getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getPhone(),
                restaurant.getLogoUrl()
        );
    }

    private Restaurant toEntity(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(dto.getId());
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhone(dto.getPhone());
        restaurant.setLogoUrl(dto.getLogoUrl());
        return restaurant;
    }
}

