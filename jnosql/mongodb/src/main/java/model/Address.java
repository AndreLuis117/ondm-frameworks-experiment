package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

@Entity
public class Address {

    public Address(){

    }

    public Address(String city, String street, String state, int postalCode){
        this.City = city;
        this.Street = street;
        this.State = state;
        this.PostalCode = postalCode;
    }

    @Column
    private String City;
    @Column
    private String Street;
    @Column
    private String State;
    @Column
    private int PostalCode;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }


    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }
}
