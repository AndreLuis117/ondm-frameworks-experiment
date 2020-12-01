package base.model;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "Order", schema = "test")
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

    @Id
    private long id;

    @ElementCollection
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    @OneToOne
    @JoinColumn
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
