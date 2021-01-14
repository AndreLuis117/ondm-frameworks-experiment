package base.service;


import base.model.Address;
import base.model.Client;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AggregationTestsService extends KunderaNeo4jService implements ServiceBase {

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try{
            CreateEntityManager();

            em.getTransaction().begin();

            var address = new Address("Rio Negrinho", "Rua Marechal Teodoro", "SC", 178);

            Client client = new Client("John Marston", address);

            em.persist(client);

            if(em.contains(client))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            em.getTransaction().commit();
            CloseEntityManager();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseEntityManager();
        }

    }

    @Override
    public void select() {

        try {
            CreateEntityManager();

            em.getTransaction().begin();

            Address address = new Address("Joinville", "Rua da saudade", "SC", 898);
            Client client = new Client("Marco Reus", address);

            Address address2 = new Address("Campo Alegre", "Rua General Osvaldo", "SC", 1009);
            Client client2 = new Client("Arthur Morgan", address2);

            Address address3 = new Address("Blumenau", "Rua João das Neves", "SC", 980);
            Client client3 = new Client("Keanu Reeves", address3);

            em.persist(client);
            em.persist(client2);
            em.persist(client3);

            var clientReturn = em.find(Client.class, client.getId());
            var clientReturn2 = em.find(Client.class, client2.getId());
            var clientReturn3 = em.find(Client.class, client3.getId());

            if(clientReturn != null)
            {
                Printer.selectSuccess();
                System.out.println("Clientes:");
                System.out.println(clientReturn.getName());
                System.out.println(clientReturn2.getName());
                System.out.println(clientReturn3.getName());

            }else
                Printer.selectFailure();

            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseEntityManager();
        }

    }

    @Override
    public void update() {

        try{
            CreateEntityManager();

            em.getTransaction().begin();

            Address address = new Address("Joinville", "Rua XV de novembro", "SC", 1100);
            Client client = new Client("Thomas A. Anderson", address);

            em.persist(client);

            client.getAddress().setPostalCode(1111);

            em.merge(client);

            var clientReturn = em.find(Client.class, client.getId());

            if(clientReturn.getAddress().getPostalCode() == client.getAddress().getPostalCode())
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            em.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseEntityManager();
        }

    }

    @Override
    public void delete() {

        try {
            CreateEntityManager();

            em.getTransaction().begin();

            Address address = new Address("Chapecó", "Rua João dos Santos", "SC", 460);
            Client client = new Client("John Wick", address);

            em.persist(client);

            em.remove(client);

            if(!em.contains(client))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseEntityManager();
        }

    }
}
