package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

import java.util.Random;

@Entity
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.Id = generateId();
        this.Name = name;
        this.Voltage = voltage;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
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
