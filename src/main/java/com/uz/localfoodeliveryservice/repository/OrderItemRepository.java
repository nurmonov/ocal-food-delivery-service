package com.uz.localfoodeliveryservice.repository;

import com.uz.localfoodeliveryservice.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Integer>{
}
