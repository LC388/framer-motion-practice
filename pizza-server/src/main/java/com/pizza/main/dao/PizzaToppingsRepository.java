package com.pizza.main.dao;

import com.pizza.main.model.PizzaToppings;
import com.pizza.main.model.PizzaToppingsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaToppingsRepository extends JpaRepository<PizzaToppings, PizzaToppingsId> {
}