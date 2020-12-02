package base.model;




import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Product", schema = "kunderaTestDb")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

    public Product(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;

    @Column
    protected String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
