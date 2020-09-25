package br.edu.univille.tcc.ondm.model;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class Motor {

    public Motor() {}

    public Motor(double power) {
        this.Power = power;
    }

    @Column
    private String Name;

    @Column
    private double Power;

    public double getPower() {
        return this.Power;
    }

    public void setPower(double power) {
        this.Power = power;
    }
}
