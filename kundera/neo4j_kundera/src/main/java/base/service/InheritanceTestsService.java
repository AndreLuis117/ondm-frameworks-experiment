package base.service;


import base.model.Electronic;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceTestsService implements ServiceBase {

    public InheritanceTestsService(){
        emf = Persistence.createEntityManagerFactory("neo4j_pu");
        em = emf.createEntityManager();
    }

    private EntityManagerFactory emf;
    private EntityManager em;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);
            em.getTransaction().begin();

            em.persist(electronic);

            if(em.contains(electronic))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);
            em.getTransaction().begin();


            em.persist(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if (electronicReturn != null)
                Printer.selectSuccess();
            else
                Printer.selectFailure();

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            Electronic electronic = new Electronic("PS4", 110);
            em.getTransaction().begin();

            em.persist(electronic);

            electronic.setVoltage(220);

            em.merge(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if(electronicReturn.getVoltage() == electronic.getVoltage())
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            Electronic electronic = new Electronic("TV SAMSUNG 4K RU7100", 220);
            em.getTransaction().begin();

            em.persist(electronic);

            em.remove(electronic);

            if(!em.contains(electronic))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
