import model.Movie;
import org.jnosql.artemis.DatabaseQualifier;
import repository.MovieRepository;
import service.CompositionTestsService;
import service.TestsWithAggregation;
import service.TestsWithoutRelationshipService;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {


    public static void main(String[] args) {
        TestsWithoutRelationshipService testsWithoutRelationshipService = new TestsWithoutRelationshipService();
        TestsWithAggregation agregationTests = new TestsWithAggregation();
        CompositionTestsService compositionTests = new CompositionTestsService();
        //testsWithoutRelationshipService.Insert();

        //testsWithoutRelationshipService.Delete();

        //agregationTests.Insert();

        //agregationTests.Select();

        //agregationTests.Update();

        //agregationTests.Delete();

        //compositionTests.Insert();

        compositionTests.Select();


    }

    private Main() {
    }
}
