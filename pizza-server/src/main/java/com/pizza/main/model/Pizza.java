package com.pizza.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pizza")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pizza {


    @Id
    @Column(name = "pizza_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "crust_id", nullable = false)
    private Crust crust;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sauce_id", nullable = false)
    private Sauce sauce;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "pizzaOrder",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "pizzas")
    private Set<Topping> toppings = new LinkedHashSet<>();

}
