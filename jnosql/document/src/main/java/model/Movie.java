package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Random;

@Entity("Movie")
public class Movie {
    public Movie(){

    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }
    public Movie(String name){
        this.id = generateId();
        this.name = name;
    }

    @Id
    private long id;
    @Column
    private String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }
}
