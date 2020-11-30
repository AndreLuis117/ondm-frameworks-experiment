package base.model;




import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Id
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
