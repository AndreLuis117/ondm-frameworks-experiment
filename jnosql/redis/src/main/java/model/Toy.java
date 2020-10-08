package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

@Entity
public class Toy extends Product {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.id = generateId();
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
