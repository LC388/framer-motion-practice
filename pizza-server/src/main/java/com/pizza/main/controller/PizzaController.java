package com.pizza.main.controller;

import com.pizza.main.model.Crust;
import com.pizza.main.model.Sauce;
import com.pizza.main.model.Topping;
import com.pizza.main.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping(value = "/crust", method = RequestMethod.GET)
    public List<Crust> getAllCrusts(){
        return pizzaService.returnAllCrusts();
    }

    @RequestMapping(value ="/sauce", method = RequestMethod.GET)
    public List<Sauce> getAllSauces(){
        return pizzaService.returnAllSauces();
    }

    @RequestMapping(value= "/veg", method = RequestMethod.GET)
    public List<Topping> getAllVegTopping(){
        return pizzaService.returnAllVegTopping();
    }

    @RequestMapping(value= "/meat", method = RequestMethod.GET)
    public List<Topping> getAllMeatTopping(){
        return pizzaService.returnAllMeatTopping();
    }


}
