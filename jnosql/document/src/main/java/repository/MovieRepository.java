package repository;

import java.util.List;
import org.jnosql.artemis.Repository;
import model.Movie;

public interface MovieRepository extends Repository<Movie, Long>{
    Movie findByName(String name);
    List<Movie> findAll();
}