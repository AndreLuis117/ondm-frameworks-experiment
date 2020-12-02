package base.model;



import javax.persistence.*;

@Entity
@Table(name = "OrderItems", schema = "redisDb@redis_pu")
public class OrderItems {

    public OrderItems(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
