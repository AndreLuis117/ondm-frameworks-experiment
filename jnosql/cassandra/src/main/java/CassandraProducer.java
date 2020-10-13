


import org.eclipse.jnosql.diana.cassandra.column.CassandraColumnFamilyManager;
import org.eclipse.jnosql.diana.cassandra.column.CassandraColumnFamilyManagerFactory;
import org.eclipse.jnosql.diana.cassandra.column.CassandraConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class CassandraProducer {

    private static final String KEY_SPACE = "cassandraExperimentDb";

    private CassandraConfiguration cassandraConfiguration;

    private CassandraColumnFamilyManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        cassandraConfiguration = new CassandraConfiguration();
        managerFactory = cassandraConfiguration.get();
    }

    @Produces
    public CassandraColumnFamilyManager getManagerCassandra() {
        return managerFactory.get(KEY_SPACE);
    }

}
