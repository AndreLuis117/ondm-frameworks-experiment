package br.edu.univille.tcc.ondm.model;

import java.util.Random;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity("Movie")
public class Movie {
    public Movie() {}

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public Movie(String name) {
        this.id = generateId();
        this.name = name;
    }

    @Id
    private long id;
    @Column
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }
}
