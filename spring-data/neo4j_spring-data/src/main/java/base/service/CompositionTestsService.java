package base.service;

import base.model.*;
import base.repository.OrderRepository;
import service.ServiceBase;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompositionTestsService implements ServiceBase {

    public CompositionTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        orderRepository = container.select(OrderRepository.class).get();
    }

    SeContainer container;
    OrderRepository orderRepository;

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
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> orderItems = new ArrayList<OrderItem>();
            orderItems.add(new OrderItem(xbox360));
            orderItems.add(new OrderItem(ps3));
            orderItems.add(new OrderItem(funko));
            Order order = new Order(orderItems, status);

            orderRepository.save(order);

            if(orderRepository.existsById(order.getId()))
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
            Electronic xboxOne = new Electronic("Xbox one", 220);
            Electronic ps4 = new Electronic("PS4", 220);
            Toy hotwheels = new Toy("Batmovel", 5);
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> OrderItem = new ArrayList<OrderItem>();
            OrderItem.add(new OrderItem(xboxOne));
            OrderItem.add(new OrderItem(ps4));
            OrderItem.add(new OrderItem(hotwheels));
            Order order = new Order(OrderItem, status);

            orderRepository.save(order);

            Optional<Order> orderReturn = orderRepository.findById(order.getId());

            if(orderReturn.isPresent()){
                Printer.selectSuccess();
                System.out.println("Itens:");

                for (OrderItem orderItem : orderReturn.get().getOrderItems())
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
            Product ps2 = new Electronic("PS2", 220);
            Product xbox = new Electronic("Xbox", 220);
            Product maxSteel = new Toy("Max Steel", 5);
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> OrderItem = new ArrayList<OrderItem>();
            OrderItem.add(new OrderItem(ps2));
            OrderItem.add(new OrderItem(xbox));
            OrderItem.add(new OrderItem(maxSteel));
            Order order = new Order(OrderItem, status);

            orderRepository.save(order);
            Toy pistaHotWheels = new Toy("Pista Hot Wheels", 5);
            order.getOrderItems().add(new OrderItem(pistaHotWheels));
            orderRepository.save(order);

            var orderReturn = orderRepository.findById(order.getId());

            if(orderReturn.get().getOrderItems().stream().anyMatch(x -> x.getProduct().getName().equals("Pista Hot Wheels")))
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
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> OrderItem = new ArrayList<OrderItem>();
            OrderItem.add(new OrderItem(nswitch));
            OrderItem.add(new OrderItem(wii));
            OrderItem.add(new OrderItem(funko));
            Order order = new Order(OrderItem, status);

            orderRepository.save(order);

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
