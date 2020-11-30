package base.model;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
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
    @Property
    private String city;
    @Property
    private String street;
    @Property
    private String state;
    @Property
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
