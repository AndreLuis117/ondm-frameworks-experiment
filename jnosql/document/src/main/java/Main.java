import service.CompositionTestsService;
import service.AggregationTestsService;
import service.NoRelationshipTestsService;

public class Main {


    public static void main(String[] args) {
        NoRelationshipTestsService noRelationshipTests = new NoRelationshipTestsService();
        AggregationTestsService agregationTests = new AggregationTestsService();
        CompositionTestsService compositionTests = new CompositionTestsService();

        //noRelationshipTests.Insert();
        //noRelationshipTests.Select();
        //noRelationshipTests.Update();
        //noRelationshipTests.Delete();


        //agregationTests.Insert();
        //agregationTests.Select();
        //agregationTests.Update();
        //agregationTests.Delete();


        //compositionTests.Insert();
        //compositionTests.Select();
        //compositionTests.Update();
        //compositionTests.Delete();

    }

    private Main() {
    }
}
