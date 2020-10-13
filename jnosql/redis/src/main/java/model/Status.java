package model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.io.Serializable;
import java.util.Random;

@Entity
public class Status implements Serializable  {

    public Status(){

    }

    public Status(String statusDescription){
        this.id = generateId();
        this.name = statusDescription;
    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
