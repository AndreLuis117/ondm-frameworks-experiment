package base.repository;


import base.model.Client;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientRepository extends Neo4jRepository<Client, Long> {
    List<Client> findAll();
}
