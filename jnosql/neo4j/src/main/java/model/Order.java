package model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Order {

    public  Order(){

    }

    @Id
    private Long id;

    public long getId() {
        return id;
    }

}
