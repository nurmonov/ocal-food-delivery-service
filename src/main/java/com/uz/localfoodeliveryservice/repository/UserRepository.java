package com.uz.localfoodeliveryservice.repository;

import com.uz.localfoodeliveryservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}