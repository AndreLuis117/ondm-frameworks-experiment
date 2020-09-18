package service;

import model.Movie;
import org.jnosql.artemis.DatabaseQualifier;
import repository.MovieRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class TestsWithoutRelationshipService implements ServiceBase {
    public TestsWithoutRelationshipService(){
        container = SeContainerInitializer.newInstance().initialize();
        movieRepository = container.select(MovieRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }
    SeContainer container;

    //Injetando o repositório
    MovieRepository movieRepository;

    public void Insert(){
        try {

            Movie movie = new Movie("Avengers");

            //Inserindo no banco
            movieRepository.save(movie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Select(){
        try{
            //Novo registro
            Movie movie = new Movie("The Batman");

            //Inserindo no banco
            movieRepository.save(movie);

            //Select pelo nome
            var movieReturn = movieRepository.findByName("The Batman");

            System.out.println("Filme encontrado: " + movieReturn.getName());

            //Update
            movie.setName("Esquadrão Suicida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(){
        //Novo registro
        Movie movie = new Movie("Gambit");

        movieRepository.save(movie);

        //Delete
        movieRepository.deleteById(movie.getId());
    }
    public void Update(){

        Movie movie = new Movie("Indiana Jones e Os Caçadores da Arca");

        movieRepository.save(movie);

        movie.setName("Indiana Jones e Os Caçadores da Arca Perdida");

        movieRepository.save(movie);
    }
}
