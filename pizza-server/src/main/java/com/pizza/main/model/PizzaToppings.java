package com.pizza.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name = "pizzaToppings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PizzaToppings {

    @EmbeddedId
    private PizzaToppingsId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topping_id", nullable = false)
    private Topping topping;

}
