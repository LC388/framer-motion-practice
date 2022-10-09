package com.pizza.main.service;

import com.pizza.main.model.Fulfillment;
import com.pizza.main.model.Order;
import com.pizza.main.model.Pizza;
import com.pizza.main.model.User;

import java.util.List;

public class UserService {
    public User findByUsername(String username) {
        return null;
    }

    public boolean create(String username, String password, String email, String firstName, String lastName, String birthday, String streetAddress, String city, String state, String zipcode, String phoneNumber) {
    return false; //use save and flush from repo methods
    }

    public List<Fulfillment> returnFulfillmentTypes() {
        return null;
    }

    public Order generateOrder(Pizza pizza) {
        //intake a pizza create pizza order and return order id to customer
        //assign employee to order
        //subtract ingredients from inventory
        return null;
    }

    public Order editPizza(Pizza pizza, int orderId) {
        //pull up order by id
        //pull up pizza on that order by pizza id
        //update that pizza on order
        //return updated order and price
        //add && subtract ingredients from inventory
        return null;
    }
}
