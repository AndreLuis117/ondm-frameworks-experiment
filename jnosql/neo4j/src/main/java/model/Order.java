package model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Order {

    public  Order(){

    }

    public Order(List<OrderItems> orderItems, Status status){
        this.orderItems = orderItems;
        this.status = status;
    }

    @Id
    private Long id;

    @Column
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    @Column
    private Status status;


    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
