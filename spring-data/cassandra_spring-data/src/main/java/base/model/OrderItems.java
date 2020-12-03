package base.model;


import org.springframework.data.cassandra.core.mapping.*;

import java.util.Random;

@UserDefinedType
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

    @Embedded.Nullable
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
