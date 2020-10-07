package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

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
        this.Id = generateId();
        this.Product = product;
    }

    @Id
    private long Id;

    @Column
    private Product Product;


    public long getId() {
        return Id;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(model.Product product) {
        Product = product;
    }
}
