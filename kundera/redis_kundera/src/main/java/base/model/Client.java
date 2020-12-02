package base.model;




import javax.persistence.*;

@Entity
@Table(name = "Client", schema = "redisDb@redis_pu")
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.name = name;
        this.address = address;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
