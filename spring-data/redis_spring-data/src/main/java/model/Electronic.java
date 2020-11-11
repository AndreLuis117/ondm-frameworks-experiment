package model;


import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Electronic extends Product {

    public Electronic(){

    }

    public Electronic(String name, int voltage){
        this.id = generateId();
        this.name = name;
        this.voltage = voltage;
    }

    private int voltage;


    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
