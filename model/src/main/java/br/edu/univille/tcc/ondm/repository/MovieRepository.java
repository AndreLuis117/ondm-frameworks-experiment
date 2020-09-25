package br.edu.univille.tcc.ondm.repository;

import java.util.List;
import br.edu.univille.tcc.ondm.model.Movie;
import jakarta.nosql.mapping.Repository;

public interface MovieRepository extends Repository<Movie, Long>{
    Movie findByName(String name);
    List<Movie> findAll();
}