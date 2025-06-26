package com.uz.localfoodeliveryservice.service;

import com.uz.localfoodeliveryservice.dto.ProductDto;
import com.uz.localfoodeliveryservice.entity.Product;
import com.uz.localfoodeliveryservice.entity.Restaurant;
import com.uz.localfoodeliveryservice.repository.ProductRepository;
import com.uz.localfoodeliveryservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return toDto(product);
    }

    public ProductDto create(ProductDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Product product = toEntity(dto);
        product.setRestaurant(restaurant);

        return toDto(productRepository.save(product));
    }

    public ProductDto update(Integer id, ProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImageUrl());
        product.setPrice(dto.getPrice());
        product.setRestaurant(restaurant);

        return toDto(productRepository.save(product));
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    // --- Manual mapping methods ---

    private ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getRestaurant().getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl()
        );
    }

    private Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImageUrl());
        // restaurant set qilishni service'da alohida qilamiz
        return product;
    }
}
