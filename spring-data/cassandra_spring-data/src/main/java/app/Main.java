package app;

import com.datastax.oss.driver.api.core.CqlSession;
import model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.cassandra.CassandraWriteTimeoutException;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Component;
import repository.StatusRepository;
import service.AggregationTestsService;
import service.CompositionTestsService;
import service.InheritanceTestsService;
import service.NoRelationshipTestsService;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;


@Component
@SpringBootApplication
@EnableCassandraRepositories("repository")
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

        //noRelationshipTests.runAll();
        compositionTests.runAll();
        //agregationTests.runAll();
        //inheritanceTests.runAll();

    }


    @Override
    protected String getKeyspaceName() {
        return "cassandraExperimentDb";
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"model"};
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
