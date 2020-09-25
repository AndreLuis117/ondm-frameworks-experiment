package br.edu.univille.tcc.ondm.document;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.eclipse.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;
import jakarta.nosql.document.DocumentCollectionManager;
import jakarta.nosql.document.DocumentCollectionManagerFactory;

@ApplicationScoped
public class DocumentCollectionManagerProducer {
    private static final String COLLECTION = "test";
    private MongoDBDocumentConfiguration configuration;
    private DocumentCollectionManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        this.configuration = new MongoDBDocumentConfiguration();
        this.managerFactory = this.configuration.get();
    }

    @Produces
    public DocumentCollectionManager getManager() {
        return this.managerFactory.get(COLLECTION);
    }
}
