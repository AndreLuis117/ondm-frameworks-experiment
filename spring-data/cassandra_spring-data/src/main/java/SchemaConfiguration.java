import model.Status;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;

@Configuration
public class SchemaConfiguration extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "cassandraExperimentDb";
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{Status.class.getPackage().getName()};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
}
