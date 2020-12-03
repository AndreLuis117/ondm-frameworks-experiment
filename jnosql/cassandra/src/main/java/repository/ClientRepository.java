package repository;

import base.model.Client;
import org.eclipse.jnosql.artemis.cassandra.column.CassandraRepository;

import java.util.List;


public interface ClientRepository extends CassandraRepository<Client, Long> {
    List<Client> findAll();
}
