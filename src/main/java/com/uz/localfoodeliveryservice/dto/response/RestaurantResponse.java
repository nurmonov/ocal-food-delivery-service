package com.uz.localfoodeliveryservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {
    private Integer id;
    private Integer ownerId;
    private String name;
    private String address;
    private String phone;
    private String logoUrl;
}
