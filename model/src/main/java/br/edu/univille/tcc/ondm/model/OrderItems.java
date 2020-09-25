package br.edu.univille.tcc.ondm.model;

import java.util.Random;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity("OrderItems")
public class OrderItems {

    public OrderItems(){
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public OrderItems(String product){
        this.Id = generateId();
        this.product = product;
    }

    @Id
    private long Id;

    @Column
    private  String product;

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
