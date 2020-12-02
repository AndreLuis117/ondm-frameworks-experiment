package base.model;




import javax.persistence.*;

@Entity
@Table(name = "Product", schema = "redisDb")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

    public Product(){

    }

    public Product(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
