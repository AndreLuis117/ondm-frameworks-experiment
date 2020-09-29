package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Order {
    public  Order(){

    };

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Order(List<OrderItems> orderItems){
        this.Id = generateId();
        this.OrderItem = orderItems;
    }

    @Id
    private long Id;

    @Column
    private List<OrderItems> OrderItem = new ArrayList<OrderItems>();

    public List<OrderItems> getOrderItem() {
        return OrderItem;
    }

    public void setOrderItem(List<OrderItems> orderItem) {
        OrderItem = orderItem;
    }

    public long getId() {
        return Id;
    }
}
