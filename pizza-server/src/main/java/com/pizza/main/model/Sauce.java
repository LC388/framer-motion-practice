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
@Table(name = "sauce")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sauce {

    @Id
    @Column(name = "sauce_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "sauce_name")
    private String sauceName;

    @Column(name = "sauce_price")
    private BigDecimal saucePrice;

    @OneToMany(mappedBy = "sauce_id")
    private Set<Pizza> pizzas = new LinkedHashSet<>();

}
