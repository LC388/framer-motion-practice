package com.pizza.main.dao;

import com.pizza.main.model.Crust;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CrustRepository extends JpaRepository<Crust, Integer> {
    List<Crust> findAll();

    Crust findByCrustName(String crustName);

}