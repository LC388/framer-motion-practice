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
@Table(name = "crust")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Crust {


    @Id
    @Column(name = "crust_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "crust_name")
    private String crustName;

    @Column(name = "crust_price")
    private BigDecimal crustPrice;

    @OneToMany(mappedBy = "crust_id")
    private Set<Pizza> pizzas = new LinkedHashSet<>();

}
