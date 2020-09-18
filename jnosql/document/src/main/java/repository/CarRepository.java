package repository;

import model.Car;
import model.Movie;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface CarRepository extends Repository<Car, Long> {
    Car findByName(String name);
    List<Car> findAll();
}
