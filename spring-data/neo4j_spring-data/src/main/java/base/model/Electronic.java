package base.model;



import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.name = name;
        this.voltage = voltage;
    }

    @Property
    private int voltage;

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
