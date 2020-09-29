package repository;

import model.Car;
import model.Dog;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface DogRepository extends Repository<Dog, Long> {
    Dog findByName(String name);
    Dog findBySpecies(String species);
    List<Dog> findAll();
}
