package base.model;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Order {

    public  Order(){

    }

    @Id
    private Long id;

    public long getId() {
        return id;
    }

}
