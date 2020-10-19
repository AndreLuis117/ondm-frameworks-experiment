package model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Random;

@Entity
public class Status {

    public Status(){

    }

    public Status(String statusDescription){
        this.name = statusDescription;
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
