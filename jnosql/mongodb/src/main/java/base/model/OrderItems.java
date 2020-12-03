package base.model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Random;

@Entity
public class OrderItems {

    public OrderItems(){

    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public OrderItems(Product product){
        this.id = generateId();
        this.product = product;
    }

    @Id
    private long id;

    @Column
    private Product product;


    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(base.model.Product product) {
        this.product = product;
    }
}
