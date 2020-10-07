package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

@Entity
public class Toy extends Product {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.Id = generateId();
        this.Name = name;
        this.AgeIndication = ageIndication;
    }

    @Column
    private int AgeIndication;

    public int getAgeIndication() {
        return AgeIndication;
    }

    public void setAgeIndication(int ageIndication) {
        AgeIndication = ageIndication;
    }
}
