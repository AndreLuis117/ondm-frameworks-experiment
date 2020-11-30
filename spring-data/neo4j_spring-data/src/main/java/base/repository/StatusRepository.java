package base.repository;



import base.model.Status;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface StatusRepository extends Neo4jRepository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
