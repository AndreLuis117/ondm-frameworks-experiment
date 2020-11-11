package model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Random;

@Table
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

    @PrimaryKey
    private long id;

    private Product product;


    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
