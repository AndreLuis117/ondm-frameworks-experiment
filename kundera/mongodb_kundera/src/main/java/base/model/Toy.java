package base.model;


import javax.persistence.*;

@Entity
@Table(name = "Toy", schema = "kunderaTestDb@mongo_pu")
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
