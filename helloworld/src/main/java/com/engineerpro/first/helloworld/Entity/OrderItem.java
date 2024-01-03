package com.engineerpro.first.helloworld.Entity;

import com.engineerpro.first.helloworld.Entity.Key.KeyMenuRestaurant;
import com.engineerpro.first.helloworld.Entity.Key.KeyOrderItem;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "orderitem")
public class OrderItem {
    @EmbeddedId
    KeyOrderItem keys;

    @ManyToOne
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name="food_id", insertable = false, updatable = false)
    private Food food;
    @Column(name = "created_date")
    private Date created_date;

    public KeyOrderItem getKeys() {
        return keys;
    }

    public void setKeys(KeyOrderItem keys) {
        this.keys = keys;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
