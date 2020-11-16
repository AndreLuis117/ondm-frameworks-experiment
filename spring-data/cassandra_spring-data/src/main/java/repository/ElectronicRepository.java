package repository;

import model.Electronic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicRepository extends CrudRepository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
