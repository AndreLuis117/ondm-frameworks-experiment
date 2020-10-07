package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Random;

@Entity
public class Client {

    public Client(){

    }

    public Client(String name, Address address){
        this.Name = name;
        this.Address = address;
    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long Id;


    @Column
    private String Name;

    @Column
    private Address Address;

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public model.Address getAddress() {
        return Address;
    }

    public void setAddress(model.Address address) {
        Address = address;
    }
}
