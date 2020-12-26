package base.model;


import javax.persistence.*;

@Entity
public class Address {

    public Address(){

    }

    public Address(String city, String street, String state, int postalCode){
        this.city = city;
        this.street = street;
        this.state = state;
        this.postalCode = postalCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
