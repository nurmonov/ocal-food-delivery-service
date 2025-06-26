package com.uz.localfoodeliveryservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String address;
    private String phone;
    private String logoUrl;
}
