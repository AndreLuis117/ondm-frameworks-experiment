package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;


@Entity
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.Id = generateId();
        this.Name = name;
        this.Voltage = voltage;
    }



    @Column
    private int Voltage;


    public int getVoltage() {
        return Voltage;
    }

    public void setVoltage(int voltage) {
        Voltage = voltage;
    }
}
