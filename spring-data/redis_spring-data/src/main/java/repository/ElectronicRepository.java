package repository;

import base.model.Electronic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectronicRepository extends CrudRepository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
