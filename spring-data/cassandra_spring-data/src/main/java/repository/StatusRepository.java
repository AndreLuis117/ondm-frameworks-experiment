package repository;

import base.model.Status;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CassandraRepository<Status, Long> {
    Status findByName(String name);
    List<Status> findAll();
}
