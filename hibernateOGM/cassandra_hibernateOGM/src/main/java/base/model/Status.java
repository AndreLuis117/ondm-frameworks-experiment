package base.model;


import javax.persistence.*;

@Entity
public class Status {

    public Status(){

    }

    public Status(String statusDescription){
        this.name = statusDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
