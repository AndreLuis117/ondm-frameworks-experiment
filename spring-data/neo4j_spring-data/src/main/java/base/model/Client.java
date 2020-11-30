package base.model;




import org.springframework.data.neo4j.core.schema.*;

@Node
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

    @Relationship(type = "resides")
    private Address address;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
