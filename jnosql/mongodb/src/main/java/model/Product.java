package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;
import org.jnosql.artemis.MappedSuperclass;

import java.util.Random;

@Entity
@MappedSuperclass
public class Product {

    public Product(){

    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    protected long id;

    @Column
    protected String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
