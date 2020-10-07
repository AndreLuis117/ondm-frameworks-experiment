package repository;

import model.Product;
import org.jnosql.artemis.Repository;

public interface ProductRepository extends Repository<Product, Long> {
}
