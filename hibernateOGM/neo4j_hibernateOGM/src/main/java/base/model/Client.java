package base.model;




import javax.persistence.*;

@Entity
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.name = name;
        this.address = address;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
