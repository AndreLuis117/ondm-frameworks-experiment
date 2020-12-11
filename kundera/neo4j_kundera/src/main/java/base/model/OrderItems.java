package base.model;


import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "OrderItems", schema = "kunderaTestDb@neo4j_pu")
public class OrderItems {

    public OrderItems(){

    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;

    public OrderItems(Product product){
        this.id = generateId();
        this.product = product;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private Product product;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
