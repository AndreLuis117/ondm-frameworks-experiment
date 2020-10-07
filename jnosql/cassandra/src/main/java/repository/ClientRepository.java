package repository;

import model.Client;
import org.jnosql.artemis.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client, Long> {
    List<Client> findAll();
}
