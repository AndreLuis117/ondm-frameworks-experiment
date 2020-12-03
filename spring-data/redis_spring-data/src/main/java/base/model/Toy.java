package base.model;


import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash
public class Toy extends Product implements Serializable {

    public Toy(){

    }

    public Toy(String name, int ageIndication){
        this.id = generateId();
        this.name = name;
        this.ageIndication = ageIndication;
    }

    private int ageIndication;

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }
}
