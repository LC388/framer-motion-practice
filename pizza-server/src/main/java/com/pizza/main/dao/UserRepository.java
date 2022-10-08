package com.pizza.main.dao;

import com.pizza.main.model.Order;
import com.pizza.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findById(Integer id);

    List<User> findAll();

    Integer findIdByUsername(String username);

}