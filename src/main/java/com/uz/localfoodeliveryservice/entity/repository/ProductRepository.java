package com.uz.localfoodeliveryservice.entity.repository;

import com.uz.localfoodeliveryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer>{
}
