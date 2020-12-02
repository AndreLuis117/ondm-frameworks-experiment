package base.service;


import base.model.Electronic;
import service.ServiceBase;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceTestsService implements ServiceBase {

    public InheritanceTestsService(){
        emf = Persistence.createEntityManagerFactory("mongo_pu");
        em = emf.createEntityManager();
    }

    EntityManagerFactory emf;
    EntityManager em;

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

            em.persist(electronic);

            if(em.contains(electronic))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);

            em.persist(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if (electronicReturn != null)
                Printer.selectSuccess();
            else
                Printer.selectFailure();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            Electronic electronic = new Electronic("PS4", 110);

            em.persist(electronic);

            electronic.setVoltage(220);

            em.merge(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if(electronicReturn.getVoltage() == electronic.getVoltage())
                Printer.updateSuccess();
            else
                Printer.updateFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            Electronic electronic = new Electronic("TV SAMSUNG 4K RU7100", 220);

            em.persist(electronic);

            em.remove(electronic);

            if(!em.contains(electronic))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
