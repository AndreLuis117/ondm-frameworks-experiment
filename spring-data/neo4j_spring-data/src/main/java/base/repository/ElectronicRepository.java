package base.repository;



import base.model.Electronic;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ElectronicRepository extends Neo4jRepository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
