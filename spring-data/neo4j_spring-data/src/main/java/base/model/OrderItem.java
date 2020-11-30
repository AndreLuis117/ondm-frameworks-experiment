package base.model;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class OrderItem {

    public OrderItem(){

    }

    public OrderItem(Product product){
        this.product = product;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "has")
    private Product product;

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
