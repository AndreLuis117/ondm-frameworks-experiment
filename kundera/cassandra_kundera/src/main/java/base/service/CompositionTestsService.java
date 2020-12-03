package base.service;

import base.model.Order;
import base.model.OrderItems;
import base.model.ProductEmbeddable;
import base.model.Status;
import utilities.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CompositionTestsService implements ServiceBase {

    public CompositionTestsService(){
        emf = Persistence.createEntityManagerFactory("cassandra_pu");
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

        try {
            ProductEmbeddable xbox360 = new ProductEmbeddable("Xbox 360");
            ProductEmbeddable ps3 = new ProductEmbeddable("PS3");
            ProductEmbeddable funko = new ProductEmbeddable("Batmovel");
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

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try {
            ProductEmbeddable xboxOne = new ProductEmbeddable("Xbox one");
            ProductEmbeddable ps4 = new ProductEmbeddable("PS4");
            ProductEmbeddable hotwheels = new ProductEmbeddable("Batmovel");
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

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            ProductEmbeddable ps2 = new ProductEmbeddable("PS2");
            ProductEmbeddable xbox = new ProductEmbeddable("Xbox");
            ProductEmbeddable maxSteel = new ProductEmbeddable("Max Steel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(ps2));
            orderItems.add(new OrderItems(xbox));
            orderItems.add(new OrderItems(maxSteel));
            Order order = new Order(orderItems, status);

            em.persist(order);
            ProductEmbeddable pistaHotWheels = new ProductEmbeddable("Pista Hot Wheels");
            order.getOrderItems().add(new OrderItems(pistaHotWheels));
            em.merge(order);

            var orderReturn = em.find(Order.class, order.getId());

            if(orderReturn.getOrderItems().stream().anyMatch(x -> x.getProduct().getName().equals("Pista Hot Wheels")))
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
            ProductEmbeddable nswitch = new ProductEmbeddable("Nintendo Switch");
            ProductEmbeddable wii = new ProductEmbeddable("Nintendo Wii");
            ProductEmbeddable funko = new ProductEmbeddable("Funko");
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

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
