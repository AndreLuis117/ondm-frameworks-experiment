package repository;

import base.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
