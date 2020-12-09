package base.service;

import base.model.Status;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoRelationshipTestsService extends KunderaNeo4jService implements ServiceBase{

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    public void insert(){
        try {
            CreateEntityManager();

            Status status = new Status("Aguardando pagamento");
            em.getTransaction().begin();

            em.persist(status);


            if(em.contains(status))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            em.getTransaction().commit();

            CloseEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void select(){
        try{
            CreateEntityManager();

            Status status = new Status("Em separação");
            em.getTransaction().begin();

            em.persist(status);

            var statusReturn = em.find(Status.class, status.getId());

            if(statusReturn != null){
                Printer.selectSuccess();
                System.out.println("Status: ");
                System.out.println(statusReturn.getName());
            }else{
                Printer.selectFailure();
            }

            em.getTransaction().commit();

            CloseEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(){

        try{
            CreateEntityManager();


            Status status = new Status("Aguardando coleta da transportadora");
            em.getTransaction().begin();

            em.persist(status);

            em.remove(status);

            if(!em.contains(status))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            em.getTransaction().commit();
            CloseEntityManager();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(){

        try{
            CreateEntityManager();


            Status status = new Status("Em transrte");
            em.getTransaction().begin();

            em.persist(status);

            status.setName("Em transporte");

            em.merge(status);

            var movieReturn = em.find(Status.class, status.getId());


            if(movieReturn.getName().equals(status.getName()))
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            em.getTransaction().commit();

            CloseEntityManager();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
