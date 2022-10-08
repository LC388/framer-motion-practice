package com.pizza.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fulfillment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fulfillment {


    @Id
    @Column(name = "fulfillment_id", nullable = false)
    private Integer id;

    @Column(name = "fulfillment_name")
    private String fulfillmentName;

    @OneToMany(mappedBy = "fulfillment")
    private Set<Order> orders = new LinkedHashSet<>();

}
