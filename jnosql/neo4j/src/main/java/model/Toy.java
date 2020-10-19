package model;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class Toy extends Product {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.name = name;
        this.ageIndication = ageIndication;
    }

    @Column
    private int ageIndication;

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }
}
