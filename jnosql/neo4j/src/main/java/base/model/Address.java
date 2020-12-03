package base.model;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

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
    private Long id;
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

    public Long getId() {
        return id;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Endereço: ");
        sb.append("id = ").append(id);
        sb.append(", cidade = ").append(city).append('\'');
        sb.append(", estado = ").append(state);
        sb.append(", Rua = ").append(street).append('\'');
        sb.append(", Número = ").append(postalCode);
        return sb.toString();
    }
}
