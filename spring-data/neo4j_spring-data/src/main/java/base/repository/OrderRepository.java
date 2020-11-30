package base.repository;



import base.model.Order;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface OrderRepository extends Neo4jRepository<Order, Long> {
    List<Order> findAll();
}
