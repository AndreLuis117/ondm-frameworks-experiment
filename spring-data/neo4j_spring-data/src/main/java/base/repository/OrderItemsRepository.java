package base.repository;

import base.model.OrderItem;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface OrderItemsRepository extends Neo4jRepository<OrderItem, Long> {
}
