package base.model;



import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import jakarta.nosql.mapping.MappedSuperclass;

@Entity
@MappedSuperclass
public class Product {

    public Product(){

    }

    @Id
    protected Long id;

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
