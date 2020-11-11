package model;




import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash
public class Address implements Serializable {

    public Address(){

    }

    public Address(String city, String street, String state, int postalCode){
        this.city = city;
        this.street = street;
        this.state = state;
        this.postalCode = postalCode;
    }

    private String city;
    private String street;
    private String state;
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
}
