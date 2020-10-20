package model;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Random;

@Entity
public class OrderItem {

    public OrderItem(){

    }

    @Id
    private Long id;

    public long getId() {
        return id;
    }

}
