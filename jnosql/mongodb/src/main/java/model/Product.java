package model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Id;
import org.jnosql.artemis.MappedSuperclass;

@MappedSuperclass
public class Product {

    Product(){

    }

    @Id
    protected long Id;

    protected String Name;

    public long getId() {
        return Id;
    }

}
