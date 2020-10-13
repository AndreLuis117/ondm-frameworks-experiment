package repository;

import jakarta.nosql.mapping.Repository;
import model.Order;

import java.util.List;

public interface OrderRepository extends Repository<Order, Long> {
    List<Order> findAll();
}
