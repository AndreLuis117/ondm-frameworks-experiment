package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Embeddable;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Motor {

    public Motor(){

    }

    public Motor(double power){
        this.Power = power;
    }

    @Column
    private String Name;

    @Column
    private double Power;



    public double getPower() {
        return Power;
    }

    public void setPower(float power) {
        Power = power;
    }
}
