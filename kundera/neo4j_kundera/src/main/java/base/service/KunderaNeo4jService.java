package base.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class KunderaNeo4jService{

    private EntityManagerFactory emf;
    protected EntityManager em;

    protected void CreateEntityManager(){
        if (emf != null && emf.isOpen())
            CloseEntityManager();
        emf = Persistence.createEntityManagerFactory("neo4j_pu");
        em = emf.createEntityManager();
    }

    protected void CloseEntityManager(){
        if (emf != null && emf.isOpen())
            emf.close();

        if (em != null && em.isOpen())
            em.close();
    }
}
