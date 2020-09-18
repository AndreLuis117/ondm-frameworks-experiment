package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Random;

@Entity
public class Car {
    public Car(){

    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Car(String name, Motor motor){
        this.Id = generateId();
        this.Name = name;
        this.Motor = motor;
    }

    @Id
    private long Id;

    @Column
    private  String Name;

    @Column
    private  Motor Motor;

    public model.Motor getMotor() {
        return Motor;
    }

    public void setMotor(model.Motor motor) {
        Motor = motor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
