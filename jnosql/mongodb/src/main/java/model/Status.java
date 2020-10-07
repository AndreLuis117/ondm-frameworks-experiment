package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Random;

@Entity
public class Status {
    public Status(){

    }

    public Status(String statusDescription){
        this.Id = generateId();
        this.Name = statusDescription;
    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long Id;


    @Column
    private String Name;

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
