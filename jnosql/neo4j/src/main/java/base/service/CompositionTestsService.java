package base.service;

import base.model.*;
import org.eclipse.jnosql.artemis.graph.GraphTemplate;
import repository.OrderRepository;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static java.util.stream.Collectors.toList;

public class CompositionTestsService implements ServiceBase {

    public CompositionTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        orderRepository = container.select(OrderRepository.class).get();
        graph = container.select(GraphTemplate.class).get();
    }

    SeContainer container;
    OrderRepository orderRepository;
    GraphTemplate graph;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try {
            Electronic xbox360 = new Electronic("Xbox 360", 110);
            Electronic ps3 = new Electronic("PS3", 220);
            Toy funko = new Toy("Batmovel", 5);
            graph.insert(xbox360);
            graph.insert(ps3);
            graph.insert(funko);

            Status status = new Status("Aguardando pagamento");
            graph.insert(status);

            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();
            OrderItem orderItem3 = new OrderItem();
            graph.insert(orderItem1);
            graph.insert(orderItem2);
            graph.insert(orderItem3);

            Order order = new Order();
            graph.insert(order);


            graph.edge(orderItem1, "has", xbox360);
            graph.edge(orderItem2, "has", ps3);
            graph.edge(orderItem3, "has", funko);

            graph.edge(order, "has", orderItem1);
            graph.edge(order, "has", orderItem2);
            graph.edge(order, "has", orderItem3);
            graph.edge(order,"is", status);


            if(orderRepository.existsById(order.getId()))
            {

                var orderItemsReturned = graph.getTraversalVertex(order.getId())
                        .out("has").<OrderItem>getResult().collect(toList());
                if(!orderItemsReturned.isEmpty())
                    Printer.insertSuccess();

            }
            else
                Printer.insertFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try {
            Electronic xboxOne = new Electronic("Xbox one", 220);
            Electronic ps4 = new Electronic("PS4", 220);
            Toy hotwheels = new Toy("Batmovel", 5);
            graph.insert(xboxOne);
            graph.insert(ps4);
            graph.insert(hotwheels);

            Status status = new Status("Aguardando pagamento");
            graph.insert(status);

            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();
            OrderItem orderItem3 = new OrderItem();
            graph.insert(orderItem1);
            graph.insert(orderItem2);
            graph.insert(orderItem3);

            Order order = new Order();
            graph.insert(order);


            graph.edge(orderItem1, "has", xboxOne);
            graph.edge(orderItem2, "has", ps4);
            graph.edge(orderItem3, "has", hotwheels);

            graph.edge(order, "has", orderItem1);
            graph.edge(order, "has", orderItem2);
            graph.edge(order, "has", orderItem3);
            graph.edge(order,"is", status);

            var orderReturn = graph.getTraversalVertex(order.getId()).<Order>getSingleResult();

            if(orderReturn.isPresent())
            {
                var orderItemsReturned = graph.getTraversalVertex(order.getId())
                        .out("has").<OrderItem>getResult().collect(toList());

                if(!orderItemsReturned.isEmpty())
                {
                    Printer.selectSuccess();

                    System.out.println("Itens:");

                    for (OrderItem orderItem : orderItemsReturned)
                    {
                        var productReturned = graph.getTraversalVertex(orderItem.getId())
                                .out("has").<Product>getSingleResult().get();

                        System.out.println(productReturned.getName());
                    }
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
            Product ps2 = new Electronic("PS2", 220);
            Product xbox = new Electronic("Xbox", 220);
            Product maxSteel = new Toy("Max Steel", 5);
            graph.insert(ps2);
            graph.insert(xbox);
            graph.insert(maxSteel);

            Status status = new Status("Aguardando pagamento");
            graph.insert(status);

            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();
            OrderItem orderItem3 = new OrderItem();
            graph.insert(orderItem1);
            graph.insert(orderItem2);
            graph.insert(orderItem3);

            Order order = new Order();
            graph.insert(order);


            graph.edge(orderItem1, "has", ps2);
            graph.edge(orderItem2, "has", xbox);
            graph.edge(orderItem3, "has", maxSteel);

            graph.edge(order, "has", orderItem1);
            graph.edge(order, "has", orderItem2);
            graph.edge(order, "has", orderItem3);
            graph.edge(order,"is", status);


            Toy pistaHotWheels = new Toy("Pista Hot Wheels", 5);
            OrderItem orderItem4 = new OrderItem();
            graph.insert(pistaHotWheels);
            graph.insert(orderItem4);
            graph.edge(orderItem4, "has", pistaHotWheels);
            graph.edge(order, "has", orderItem4);

            var orderReturn = orderRepository.findById(order.getId());

            var orderItemsReturned = graph.getTraversalVertex(order.getId())
                    .out("has").<OrderItem>getResult().collect(toList());

            if(orderItemsReturned.size() > 3)
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
            Electronic nswitch = new Electronic("Nintendo Switch", 220);
            Electronic wii = new Electronic("Nintendo Wii", 220);
            Toy funko = new Toy("Funko", 5);
            graph.insert(nswitch);
            graph.insert(wii);
            graph.insert(funko);

            Status status = new Status("Aguardando pagamento");
            graph.insert(status);

            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();
            OrderItem orderItem3 = new OrderItem();
            graph.insert(orderItem1);
            graph.insert(orderItem2);
            graph.insert(orderItem3);

            Order order = new Order();
            graph.insert(order);


            graph.edge(orderItem1, "has", nswitch);
            graph.edge(orderItem2, "has", wii);
            graph.edge(orderItem3, "has", funko);

            graph.edge(order, "has", orderItem1);
            graph.edge(order, "has", orderItem2);
            graph.edge(order, "has", orderItem3);
            graph.edge(order,"is", status);

            orderRepository.deleteById(order.getId());

            if(!orderRepository.existsById(order.getId()))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
