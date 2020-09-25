package br.edu.univille.tcc.ondm.model;

import java.util.Random;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity
public class Car {
    public Car() {}

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Car(String name, Motor motor) {
        this.Id = generateId();
        this.Name = name;
        this.Motor = motor;
    }

    @Id
    private long Id;

    @Column
    private String Name;

    @Column
    private Motor Motor;

    public Motor getMotor() {
        return this.Motor;
    }

    public void setMotor(Motor motor) {
        this.Motor = motor;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public long getId() {
        return this.Id;
    }
}
