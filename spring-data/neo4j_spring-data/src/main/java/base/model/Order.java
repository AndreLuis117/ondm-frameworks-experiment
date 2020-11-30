package base.model;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Order {

    public  Order(){

    }
    public Order(List<OrderItem> orderItems, Status status){
        this.orderItems = orderItems;
        this.status = status;
    }

    @Id
    private Long id;

    @Relationship(type = "is")
    private Status status;

    @Relationship(type = "has")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();


    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
