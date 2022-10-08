package com.pizza.main.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PizzaOrderId implements Serializable {
    private static final long serialVersionUID = -1450839235253852786L;
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PizzaOrderId entity = (PizzaOrderId) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.pizzaId, entity.pizzaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, pizzaId);
    }

}