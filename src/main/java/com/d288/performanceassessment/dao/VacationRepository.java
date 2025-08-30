package com.d288.performanceassessment.dao;

import com.d288.performanceassessment.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
