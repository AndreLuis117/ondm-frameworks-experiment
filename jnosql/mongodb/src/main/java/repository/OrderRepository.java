package repository;

import model.Movie;
import model.Order;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface OrderRepository extends Repository<Order, Long> {
    List<Order> findAll();
}
