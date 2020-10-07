

import org.jnosql.diana.api.column.ColumnConfiguration;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerFactory;
import org.jnosql.diana.cassandra.column.CassandraConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ColumnFamilyManagerProducer {

    private static final String KEY_SPACE = "test";

    private ColumnConfiguration cassandraConfiguration;

    private ColumnFamilyManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        cassandraConfiguration = new CassandraConfiguration();
        managerFactory = cassandraConfiguration.get();
    }


    @Produces
    public ColumnFamilyManager getManagerCassandra() {
        return managerFactory.get(KEY_SPACE);
    }

}
