package base.service;

import base.model.Status;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class NoRelationshipTestsService implements ServiceBase {

    public NoRelationshipTestsService(){
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

    public void insert(){
        try {
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();
            Status status = new Status("Aguardando pagamento");


            em.persist(status);

            if(em.contains(status))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Status status = new Status("Em separação");

            em.persist(status);

            var statusReturn = em.find(Status.class, status.getId());

            if(statusReturn != null){
                Printer.selectSuccess();
                System.out.println("Status: ");
                System.out.println(statusReturn.getName());
            }else{
                Printer.selectFailure();
            }
            transactionManager.commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(){

        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Status status = new Status("Aguardando coleta da transportadora");

            em.persist(status);

            em.remove(status);

            if(!em.contains(status))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            transactionManager.commit();


        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(){

        try{
            TransactionManager transactionManager =
                    com.arjuna.ats.jta.TransactionManager.transactionManager();
            transactionManager.begin();

            Status status = new Status("Em transrte");

            em.persist(status);

            status.setName("Em transporte");

            em.merge(status);

            var movieReturn = em.find(Status.class, status.getId());


            if(movieReturn.getName().equals(status.getName()))
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            transactionManager.commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
