package service;

import model.Movie;
import org.jnosql.artemis.DatabaseQualifier;
import repository.MovieRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class NoRelationshipTestsService implements ServiceBase {

    public NoRelationshipTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        movieRepository = container.select(MovieRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    MovieRepository movieRepository;

    public void Insert(){
        try {
            Movie movie = new Movie("Avengers");

            movieRepository.save(movie);

            if(movieRepository.existsById(movie.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Select(){
        try{
            Movie movie = new Movie("The Batman");

            movieRepository.save(movie);

            var movieReturn = movieRepository.findByName("The Batman");

            System.out.println("Filme encontrado: " + movieReturn.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(){

        try{
            Movie movie = new Movie("Gambit");

            movieRepository.save(movie);

            movieRepository.deleteById(movie.getId());

            if(!movieRepository.existsById(movie.getId()))
                System.out.println("Objeto deletado com sucesso!");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void Update(){

        try{
            Movie movie = new Movie("Indiana Jones e Os Caçadores da Arca");

            movieRepository.save(movie);

            movie.setName("Indiana Jones e Os Caçadores da Arca Perdida");

            movieRepository.save(movie);

            var movieReturn = movieRepository.findByName("Indiana Jones e Os Caçadores da Arca Perdida");

            if(movieReturn != null)
                System.out.println("Objeto atualizado no banco de dados!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
