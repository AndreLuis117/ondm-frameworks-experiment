package base.service;


import base.model.Electronic;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

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
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Electronic electronic = new Electronic("Xbox One X", 220);

            em.persist(electronic);

            if(em.contains(electronic))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            transactionManager.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Electronic electronic = new Electronic("Xbox One X", 220);

            em.persist(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if (electronicReturn != null)
                Printer.selectSuccess();
            else
                Printer.selectFailure();

            transactionManager.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Electronic electronic = new Electronic("PS4", 110);

            em.persist(electronic);

            electronic.setVoltage(220);

            em.merge(electronic);

            var electronicReturn = em.find(Electronic.class, electronic.getId());

            if(electronicReturn.getVoltage() == electronic.getVoltage())
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            transactionManager.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Electronic electronic = new Electronic("TV SAMSUNG 4K RU7100", 220);

            em.persist(electronic);

            em.remove(electronic);

            if(!em.contains(electronic))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            transactionManager.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
