package base.model;



import javax.persistence.*;

@Entity
@Table(name = "OrderItems", schema = "kunderaTestDb@cassandra_pu")
public class OrderItems {

    public OrderItems(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public OrderItems(ProductEmbeddable product){
        this.product = product;
    }

    private ProductEmbeddable product;


    public ProductEmbeddable getProduct() {
        return product;
    }

    public void setProduct(ProductEmbeddable product) {
        this.product = product;
    }
}
