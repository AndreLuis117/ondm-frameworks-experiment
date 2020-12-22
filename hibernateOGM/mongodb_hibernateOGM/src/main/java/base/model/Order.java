package base.model;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

    public  Order(){

    }


    public Order(List<OrderItems> orderItems, Status status){
        this.orderItems = orderItems;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ElementCollection
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    @OneToOne
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
