package model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Random;

@Entity
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.name = name;
    }

    @Id
    private Long id;

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
