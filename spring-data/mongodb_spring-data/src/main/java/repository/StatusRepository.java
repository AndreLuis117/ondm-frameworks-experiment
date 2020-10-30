package repository;

import model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatusRepository extends MongoRepository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
