package com.uz.localfoodeliveryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private Integer restaurantId;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
}

