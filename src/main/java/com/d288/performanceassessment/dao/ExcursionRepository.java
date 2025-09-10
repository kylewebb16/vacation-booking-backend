package com.d288.performanceassessment.dao;

import com.d288.performanceassessment.entity.CartItem;
import com.d288.performanceassessment.entity.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
