package com.pizza.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "topping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "topping_id", nullable = false)
    private Long topping_id;

    @Lob
    @Column(name = "topping_type")
    private String toppingType;

    @Lob
    @Column(name = "topping_name")
    private String toppingName;

    @Column(name = "topping_price")
    private BigDecimal toppingPrice;

    @ManyToMany
    @JoinTable(name = "pizzaToppings",
            joinColumns = @JoinColumn(name = "topping_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private Set<Pizza> pizzas = new LinkedHashSet<>();

}
