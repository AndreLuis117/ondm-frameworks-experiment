package repository;

import jakarta.nosql.mapping.Repository;
import base.model.Product;

public interface ProductRepository extends Repository<Product, Long> {
}
