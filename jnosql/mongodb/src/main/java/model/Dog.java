package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

import java.util.Random;

@Entity
public class Dog extends Animal {

    public Dog(){

    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Dog(String name, String species){
        this.Id = generateId();
        this.Species = species;
        this.Name = name;
    }

    @Column
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
