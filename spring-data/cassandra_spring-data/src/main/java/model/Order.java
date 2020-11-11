package model;



import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Table
public class Order {

    public  Order(){

    };

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Order(List<OrderItems> orderItems, Status status){
        this.id = generateId();
        this.orderItems = orderItems;
        this.status = status;
    }

    @PrimaryKey
    private long id;

    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

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
