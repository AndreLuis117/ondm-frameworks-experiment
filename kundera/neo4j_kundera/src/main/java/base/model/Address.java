package base.model;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Address", schema = "kunderaTestDb@neo4j_pu")
public class Address {

    public Address(){

    }

    public Address(String city, String street, String state, int postalCode){
        this.id = generateId();
        this.city = city;
        this.street = street;
        this.state = state;
        this.postalCode = postalCode;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String state;
    @Column
    private int postalCode;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
