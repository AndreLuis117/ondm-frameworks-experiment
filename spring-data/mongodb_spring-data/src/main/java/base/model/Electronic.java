package base.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.id = generateId();
        this.name = name;
        this.voltage = voltage;
    }

    private int voltage;

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
