package repository;

import model.Status;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface StatusRepository extends Repository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
