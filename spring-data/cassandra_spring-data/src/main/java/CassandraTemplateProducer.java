import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class CassandraTemplateProducer  {

    @Produces
    @Singleton
    public CqlSession createSession() {
        return CqlSession.builder().withKeyspace("cassandraExperimentDb").build();
    }

    @Produces
    @ApplicationScoped
    public CassandraOperations createCassandraOperations(CqlSession session) throws Exception {

        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(session));
        mappingContext.afterPropertiesSet();

        MappingCassandraConverter cassandraConverter = new MappingCassandraConverter(mappingContext);
        cassandraConverter.afterPropertiesSet();

        return new CassandraAdminTemplate(session, cassandraConverter);
    }

    public void close(@Disposes CqlSession session) {
        session.close();
    }

}
