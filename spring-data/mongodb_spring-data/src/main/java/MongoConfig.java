import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.enterprise.inject.Produces;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = {"base.repository"})
public class MongoConfig extends AbstractMongoClientConfiguration  {
    @Override
    protected String getDatabaseName() {
        return "springDataTestDb";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/springDataTestDb");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    @Produces
    public MongoOperations mongoOperations() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("base/repository");
    }

}