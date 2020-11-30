package base.model;


import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class Toy extends Product {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.name = name;
        this.ageIndication = ageIndication;
    }

    @Property
    private int ageIndication;

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }
}
