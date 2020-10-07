package repository;

import model.Electronic;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface ElectronicRepository extends Repository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
