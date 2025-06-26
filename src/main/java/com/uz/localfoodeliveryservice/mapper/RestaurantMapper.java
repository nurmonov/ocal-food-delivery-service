package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.RestaurantRequest;
import com.uz.localfoodeliveryservice.dto.response.RestaurantResponse;
import com.uz.localfoodeliveryservice.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant restaurantDtoToRestaurant(RestaurantRequest restaurant);
    RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant);
}
