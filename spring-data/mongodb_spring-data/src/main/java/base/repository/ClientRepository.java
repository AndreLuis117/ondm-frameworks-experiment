package base.repository;

import base.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, Long> {
    List<Client> findAll();
}
