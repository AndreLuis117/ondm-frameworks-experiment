package base.model;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderItems {

    public OrderItems(){

    }


    public OrderItems(ProductEmbeddable product){
        this.product = product;
    }

    @Embedded
    private ProductEmbeddable product;


    public ProductEmbeddable getProduct() {
        return product;
    }

    public void setProduct(ProductEmbeddable product) {
        this.product = product;
    }
}
