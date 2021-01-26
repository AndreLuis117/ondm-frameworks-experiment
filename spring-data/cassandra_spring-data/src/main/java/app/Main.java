package app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Component;
import base.service.AggregationTestsService;
import base.service.CompositionTestsService;
import base.service.InheritanceTestsService;
import base.service.NoRelationshipTestsService;

import java.util.Arrays;
import java.util.List;


@Component
@SpringBootApplication
@EnableCassandraRepositories("base.repository")
public class Main extends AbstractCassandraConfiguration {


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

        noRelationshipTests.runAll();
        //compositionTests.runAll();
        //agregationTests.runAll();
        //inheritanceTests.runAll();

    }


    @Override
    protected String getKeyspaceName() {
        return "cassandraExperimentDb";
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"base/model"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE;
    }

    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Arrays.asList(
                CreateKeyspaceSpecification.createKeyspace("springDataKeySpace")
                        .ifNotExists()
        );
    }


}
