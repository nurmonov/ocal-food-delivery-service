package com.uz.localfoodeliveryservice.repository;

import com.uz.localfoodeliveryservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer> {
}
