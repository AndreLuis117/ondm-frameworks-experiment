package base.model;

import javax.persistence.*;

@Embeddable
public class ProductEmbeddable extends Product{

    public ProductEmbeddable(){

    }

    public ProductEmbeddable(String name){
        this.name = name;
    }

    @Column
    protected String id;

    @Column
    protected String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
