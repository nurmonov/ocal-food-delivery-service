package com.uz.localfoodeliveryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Integer id;
    private Integer ownerId; // User id
    private String name;
    private String address;
    private String phone;
    private String logoUrl;
}

