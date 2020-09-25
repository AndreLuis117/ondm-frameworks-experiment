package br.edu.univille.tcc.ondm.repository;

import java.util.List;
import br.edu.univille.tcc.ondm.model.Car;
import jakarta.nosql.mapping.Repository;

public interface CarRepository extends Repository<Car, Long> {
    Car findByName(String name);
    List<Car> findAll();
}
