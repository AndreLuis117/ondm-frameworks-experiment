package base.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class KunderaNeo4jService{

    private EntityManagerFactory emf;
    protected EntityManager em;

    protected void CreateEntityManager(){
        emf = Persistence.createEntityManagerFactory("neo4j_pu");
        em = emf.createEntityManager();
    }

    protected void CloseEntityManager(){
        emf.close();
        em.close();
    }
}
