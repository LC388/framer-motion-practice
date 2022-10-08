package com.pizza.main.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PizzaToppingsId implements Serializable {
    private static final long serialVersionUID = -6219530231144372065L;
    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;

    @Column(name = "topping_id", nullable = false)
    private Integer toppingId;

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getToppingId() {
        return toppingId;
    }

    public void setToppingId(Integer toppingId) {
        this.toppingId = toppingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PizzaToppingsId entity = (PizzaToppingsId) o;
        return Objects.equals(this.pizzaId, entity.pizzaId) &&
                Objects.equals(this.toppingId, entity.toppingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaId, toppingId);
    }

}