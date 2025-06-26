package com.uz.localfoodeliveryservice.repository;

import com.uz.localfoodeliveryservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository <Restaurant, Integer>{
}
