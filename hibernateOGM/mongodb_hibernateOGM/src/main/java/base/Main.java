package base;


import base.service.AggregationTestsService;
import base.service.CompositionTestsService;
import base.service.InheritanceTestsService;
import base.service.NoRelationshipTestsService;

public class Main {

    public static void main(String[] args) {

        NoRelationshipTestsService noRelationshipTests = new NoRelationshipTestsService();
        CompositionTestsService compositionTests = new CompositionTestsService();
        AggregationTestsService agregationTests = new AggregationTestsService();
        InheritanceTestsService inheritanceTests = new InheritanceTestsService();

        //noRelationshipTests.insert();
        //noRelationshipTests.select();
        //noRelationshipTests.update();
        //noRelationshipTests.delete();


        //agregationTests.insert();
        //agregationTests.select();
        //agregationTests.update();
        //agregationTests.delete();


        //compositionTests.insert();
        //compositionTests.select();
        //compositionTests.update();
        //compositionTests.delete();

        //inheritanceTests.insert();
        //inheritanceTests.update();
        //inheritanceTests.delete();
        //inheritanceTests.select();

        //noRelationshipTests.runAll();
        //agregationTests.runAll();
        compositionTests.runAll();
        //inheritanceTests.runAll();


    }

}
