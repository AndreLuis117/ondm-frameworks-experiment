package base.model;

import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity
public class OrderItem {

    public OrderItem(){

    }

    @Id
    private Long id;

    public long getId() {
        return id;
    }

}
