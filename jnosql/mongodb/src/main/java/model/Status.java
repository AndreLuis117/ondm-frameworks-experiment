package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Random;

@Entity
public class Status {
    public Status(){

    }

    public Status(String description){
        this.Id = generateId();
        this.Description = description;
    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long Id;

    @Column
    private String Description;

    public long getId() {
        return Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
