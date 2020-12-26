package base.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
  
    public void setId(String id) {
        this.id = id;
    }
}
