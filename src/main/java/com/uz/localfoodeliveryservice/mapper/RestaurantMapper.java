package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.RestaurantDto;
import com.uz.localfoodeliveryservice.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant restaurantDtoToRestaurant(RestaurantDto restaurant);
    RestaurantDto restaurantToRestaurantResponse(Restaurant restaurant);
}
