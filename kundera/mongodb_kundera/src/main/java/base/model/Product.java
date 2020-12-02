package base.model;




import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Product", schema = "testDB")
@Inheritance(strategy=InheritanceType.JOINED)
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
