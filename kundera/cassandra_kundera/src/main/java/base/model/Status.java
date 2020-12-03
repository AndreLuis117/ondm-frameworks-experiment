package base.model;


import javax.persistence.*;

@Entity
@Table(name = "Status", schema = "kunderaTestDb@cassandra_pu")
public class Status {

    public Status(){

    }

    public Status(String statusDescription){
        //this.id = generateId();
        this.name = statusDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
