package base.repository;

import jakarta.nosql.mapping.Repository;
import base.model.Electronic;

import java.util.List;

public interface ElectronicRepository extends Repository<Electronic, Long> {
    Electronic findByName(String name);
    List<Electronic> findAll();
}
