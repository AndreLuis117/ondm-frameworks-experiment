package base.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class KunderaNeo4jService{

    protected EntityManager CreateEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neo4j_pu");

        return emf.createEntityManager();
    }
}
