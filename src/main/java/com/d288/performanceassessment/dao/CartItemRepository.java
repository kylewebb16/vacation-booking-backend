package com.d288.performanceassessment.dao;

import com.d288.performanceassessment.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
