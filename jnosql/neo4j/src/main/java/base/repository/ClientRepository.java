package base.repository;

import jakarta.nosql.mapping.Repository;
import base.model.Client;

import java.util.List;

public interface ClientRepository extends Repository<Client, Long> {
    List<Client> findAll();
}
