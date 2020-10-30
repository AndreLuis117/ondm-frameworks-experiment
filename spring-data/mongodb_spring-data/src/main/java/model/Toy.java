package model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Toy extends Product {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.id = generateId();
        this.name = name;
        this.ageIndication = ageIndication;
    }

    private int ageIndication;

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }
}
