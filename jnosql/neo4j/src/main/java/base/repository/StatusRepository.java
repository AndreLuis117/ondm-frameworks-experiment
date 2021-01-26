package base.repository;

import jakarta.nosql.mapping.Repository;
import base.model.Status;
import java.util.List;

public interface StatusRepository extends Repository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
