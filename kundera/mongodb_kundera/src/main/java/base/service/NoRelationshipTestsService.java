package base.service;

import base.model.Status;
import service.ServiceBase;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            Status status = new Status("Aguardando pagamento");

            em.persist(status);

            if(em.contains(status))
                Printer.insertSuccess();
            else
                Printer.insertFailure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try{
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(){

        try{
            Status status = new Status("Aguardando coleta da transportadora");

            em.persist(status);

            em.remove(status);

            if(!em.contains(status))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(){

        try{
            Status status = new Status("Em transrte");

            em.persist(status);

            status.setName("Em transporte");

            em.merge(status);

            var movieReturn = em.find(Status.class, status.getId());


            if(movieReturn.getName().equals(status.getName()))
                Printer.updateSuccess();
            else
                Printer.updateFailure();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
