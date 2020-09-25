package br.edu.univille.tcc.ondm.document.service;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.artemis.DatabaseQualifier;
import br.edu.univille.tcc.ondm.model.Movie;
import br.edu.univille.tcc.ondm.repository.MovieRepository;

public class NoRelationshipTestsService implements ServiceBase {

    public NoRelationshipTestsService() {
        this.container = SeContainerInitializer.newInstance().initialize();
        this.movieRepository = this.container.select(MovieRepository.class).select(DatabaseQualifier.ofDocument())
                .get();
    }

    SeContainer container;
    MovieRepository movieRepository;

    public void Insert() {
        try {
            Movie movie = new Movie("Avengers");

            this.movieRepository.save(movie);

            if (this.movieRepository.existsById(movie.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Select() {
        try {
            Movie movie = new Movie("The Batman");

            this.movieRepository.save(movie);

            var movieReturn = this.movieRepository.findByName("The Batman");

            System.out.println("Filme encontrado: " + movieReturn.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete() {

        try {
            Movie movie = new Movie("Gambit");

            this.movieRepository.save(movie);

            this.movieRepository.deleteById(movie.getId());

            if (!this.movieRepository.existsById(movie.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Update() {

        try {
            Movie movie = new Movie("Indiana Jones e Os Caçadores da Arca");

            this.movieRepository.save(movie);

            movie.setName("Indiana Jones e Os Caçadores da Arca Perdida");

            this.movieRepository.save(movie);

            var movieReturn = this.movieRepository.findByName("Indiana Jones e Os Caçadores da Arca Perdida");

            if (movieReturn != null)
                System.out.println("Objeto atualizado no banco de dados!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
