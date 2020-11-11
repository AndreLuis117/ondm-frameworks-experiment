package model;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Random;

@RedisHash
public class OrderItems implements Serializable {

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
