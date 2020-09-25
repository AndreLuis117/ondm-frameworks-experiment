package br.edu.univille.tcc.ondm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity
public class Order {
    public Order() {}

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Order(List<OrderItems> orderItems) {
        this.Id = generateId();
        this.OrderItem = orderItems;
    }

    @Id
    private long Id;

    @Column
    private List<OrderItems> OrderItem = new ArrayList<OrderItems>();

    public List<OrderItems> getOrderItem() {
        return this.OrderItem;
    }

    public void setOrderItem(List<OrderItems> orderItem) {
        this.OrderItem = orderItem;
    }

    public long getId() {
        return this.Id;
    }
}
