package base.model;




import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Client", schema = "kunderaTestDb@neo4j_pu")
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.id = generateId();
        this.name = name;
        this.address = address;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;

    @Column
    private String name;

    @OneToOne
    private Address address;



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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
