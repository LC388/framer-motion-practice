package com.pizza.main.dao;

import com.pizza.main.model.PizzaOrder;
import com.pizza.main.model.PizzaOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, PizzaOrderId> {
}