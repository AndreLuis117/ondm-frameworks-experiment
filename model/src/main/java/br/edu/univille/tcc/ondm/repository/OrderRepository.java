package br.edu.univille.tcc.ondm.repository;

import java.util.List;
import br.edu.univille.tcc.ondm.model.Order;
import jakarta.nosql.mapping.Repository;

public interface OrderRepository extends Repository<Order, Long> {
    List<Order> findAll();
}
