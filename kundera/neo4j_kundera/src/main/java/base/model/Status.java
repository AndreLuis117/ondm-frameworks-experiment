package base.model;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Status", schema = "kunderaTestDb@neo4j_pu")
public class Status {

    public Status(){

    }

    public Status(String statusDescription){
        this.id = generateId();
        this.name = statusDescription;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
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

    public void setId(long id) {
        this.id = id;
    }
}
