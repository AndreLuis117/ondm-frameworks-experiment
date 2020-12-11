package base.service;

import base.model.*;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CompositionTestsService extends KunderaNeo4jService implements ServiceBase {


    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try {

            CreateEntityManager();

            em.getTransaction().begin();


            Product xbox360 = new Product("Xbox 360");
            Product ps3 = new Product("PS3");
            Product funko = new Product("Batmovel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(xbox360));
            orderItems.add(new OrderItems(ps3));
            orderItems.add(new OrderItems(funko));
            Order order = new Order(orderItems, status);

            em.persist(order);

            if(em.contains(order))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

            em.getTransaction().commit();

            CloseEntityManager();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try {
            CreateEntityManager();
            em.getTransaction().begin();

            Product xboxOne = new Product("Xbox one");
            Product ps4 = new Product("PS4");
            Product hotwheels = new Product("Batmovel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(xboxOne));
            orderItems.add(new OrderItems(ps4));
            orderItems.add(new OrderItems(hotwheels));
            Order order = new Order(orderItems, status);

            em.persist(order);

            var orderReturn = em.find(Order.class, order.getId());

            if(orderReturn != null){
                Printer.selectSuccess();
                System.out.println("Itens:");

                for (OrderItems orderItem : orderReturn.getOrderItems())
                {
                    System.out.println(orderItem.getProduct().getName());
                }
            }else
                Printer.selectFailure();
            em.getTransaction().commit();

            CloseEntityManager();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            CreateEntityManager();
            em.getTransaction().begin();

            Product ps2 = new Product("PS2");
            Product xbox = new Product("Xbox");
            Product maxSteel = new Product("Max Steel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(ps2));
            orderItems.add(new OrderItems(xbox));
            orderItems.add(new OrderItems(maxSteel));
            Order order = new Order(orderItems, status);

            em.persist(order);
            Product pistaHotWheels = new Product("Pista Hot Wheels");
            order.getOrderItems().add(new OrderItems(pistaHotWheels));
            em.merge(order);

            var orderReturn = em.find(Order.class, order.getId());

            if(orderReturn.getOrderItems().stream().anyMatch(x -> x.getProduct().getName().equals("Pista Hot Wheels")))
                Printer.updateSuccess();
            else
                Printer.updateFailure();

            em.getTransaction().commit();

            CloseEntityManager();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            CreateEntityManager();
            em.getTransaction().begin();

            Product nswitch = new Product("Nintendo Switch");
            Product wii = new Product("Nintendo Wii");
            Product funko = new Product("Funko");
            Status status = new Status("Aguardando pagamento");


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(nswitch));
            orderItems.add(new OrderItems(wii));
            orderItems.add(new OrderItems(funko));
            Order order = new Order(orderItems, status);

            em.persist(order);

            em.remove(order);

            if(!em.contains(order))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

            em.getTransaction().commit();

            CloseEntityManager();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
