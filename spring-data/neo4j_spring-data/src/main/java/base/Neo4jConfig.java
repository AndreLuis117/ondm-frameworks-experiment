package base;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class Neo4jConfig {

    @Produces
    @ApplicationScoped
    public Driver driver() {
        return GraphDatabase
                .driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "test"));
    }

    public void close(@Disposes Driver driver) {
        driver.close();
    }

    @Produces @Singleton
    public DatabaseSelectionProvider getDatabaseSelectionProvider() {
        return DatabaseSelectionProvider.createStaticDatabaseSelectionProvider("neo4j");
    }
}