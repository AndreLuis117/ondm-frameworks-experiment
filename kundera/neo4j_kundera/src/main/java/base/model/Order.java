package base.model;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "Order", schema = "kunderaTestDb@neo4j_pu")
public class Order {

    public  Order(){

    }


    public Order(List<OrderItems> orderItems, Status status){
        this.id = generateId();
        this.orderItems = orderItems;
        this.status = status;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "status")
    private Status status;


    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
