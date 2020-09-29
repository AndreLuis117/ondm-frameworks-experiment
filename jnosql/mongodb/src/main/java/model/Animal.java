package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Id;
import org.jnosql.artemis.MappedSuperclass;

@MappedSuperclass
public class Animal {

    public Animal(){

    }

    @Id
    protected long Id;

    @Column
    protected String Species;

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public long getId() {
        return Id;
    }
}
