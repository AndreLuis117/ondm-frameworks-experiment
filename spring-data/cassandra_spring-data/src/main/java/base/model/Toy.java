package base.model;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
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
