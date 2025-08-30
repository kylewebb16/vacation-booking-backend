package com.d288.performanceassessment.dao;

import com.d288.performanceassessment.entity.CartItem;
import com.d288.performanceassessment.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
