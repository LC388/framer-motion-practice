package com.pizza.main.controller;

import com.pizza.main.model.Fulfillment;
import com.pizza.main.model.Order;
import com.pizza.main.model.Pizza;
import com.pizza.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/fulfillment", method = RequestMethod.GET)
    public List<Fulfillment> getAllFulfillmentTypes(){
        return userService.returnFulfillmentTypes();
    }

    @RequestMapping(value= "/order", method =RequestMethod.POST)
    public Order generateOrder(@Valid Pizza pizza){
        return userService.generateOrder(pizza);
    }

    @RequestMapping(value= "/order/{id}", method =RequestMethod.PUT)
    public Order editPizza(@Valid Pizza pizza, int orderId){
        return userService.editPizza(pizza, orderId);
    }


}
