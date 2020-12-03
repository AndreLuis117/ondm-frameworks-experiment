package repository;

import base.model.Electronic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ElectronicRepository extends MongoRepository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
