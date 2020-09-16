import model.Movie;
import org.jnosql.artemis.DatabaseQualifier;
import repository.MovieRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            //Injetando o repositório
            MovieRepository repository = container.select(MovieRepository.class)
                    .select(DatabaseQualifier.ofDocument()).get();
            Movie movie = new Movie();

            movie.setId(3);
            movie.setName("The Batman");

            repository.save(movie);

            var movieReturn = repository.findByName("The Batman");
            System.out.println("Filme encontrado: " + movieReturn.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Main() {
    }
}
