package base.model;




import javax.persistence.*;
import java.util.Random;

@Embeddable
public class OrderItems {

    public OrderItems(){

    }

    private static final Random RANDOM = new Random();

    public static long generateId() {
        return RANDOM.nextLong();
    }

    public OrderItems(Product product){
        this.product = product;
    }


    @OneToOne
    @JoinColumn
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
