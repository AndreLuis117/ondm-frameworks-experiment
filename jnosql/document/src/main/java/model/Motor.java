package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Embeddable;
import org.jnosql.artemis.Id;

@Embeddable
public class Motor {

    public Motor(){

    }

    @Column
    private String Name;

    @Column
    private float Power;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public float getPower() {
        return Power;
    }

    public void setPower(float power) {
        Power = power;
    }
}
