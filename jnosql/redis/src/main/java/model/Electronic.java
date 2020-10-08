package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;


@Entity
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.id = generateId();
        this.name = name;
        this.voltage = voltage;
    }

    @Column
    private int voltage;


    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
