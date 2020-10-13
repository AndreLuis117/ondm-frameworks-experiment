package repository;

import jakarta.nosql.mapping.Repository;
import model.Product;

public interface ProductRepository extends Repository<Product, Long> {
}
