package model;



import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Random;

@RedisHash
public class Status implements Serializable  {

    public Status(){

    }

    public Status(String statusDescription){
        this.id = generateId();
        this.name = statusDescription;
    }
    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    @Id
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
