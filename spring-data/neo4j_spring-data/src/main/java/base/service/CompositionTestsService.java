package base.service;

import base.model.*;
import base.repository.ElectronicRepository;
import base.repository.OrderItemsRepository;
import base.repository.OrderRepository;
import base.repository.ProductRepository;
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
        orderItemsRepository = container.select(OrderItemsRepository.class).get();
    }

    SeContainer container;
    OrderRepository orderRepository;
    OrderItemsRepository orderItemsRepository;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try {
            Product xbox360 = new Product("Xbox 360");
            Product ps3 = new Product("PS3");
            Product funko = new Product("Batmovel");
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
            Product xboxOne = new Product("Xbox one");
            Product ps4 = new Product("PS4");
            Product hotwheels = new Product("Batmovel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> OrderItem = new ArrayList<OrderItem>();
            OrderItem.add(new OrderItem(xboxOne));
            OrderItem.add(new OrderItem(ps4));
            OrderItem.add(new OrderItem(hotwheels));
            Order order = new Order(OrderItem, status);

            orderRepository.save(order);

            var orderReturn = orderRepository.findById(order.getId());

            if(orderReturn.isPresent())
            {
                Printer.selectSuccess();
                System.out.println("Itens:");

                for (OrderItem orderItem : orderReturn.get().getOrderItems())
                {
                    var orderItemReturn = orderItemsRepository.findById(orderItem.getId());

                    if (orderItemReturn.isPresent())
                        System.out.println(orderItemReturn.get().getProduct().getName());
                }
            }
            else
                Printer.selectFailure();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            Product ps2 = new Product("PS2");
            Product xbox = new Product("Xbox");
            Product maxSteel = new Product("Max Steel");
            Status status = new Status("Aguardando pagamento");


            List<OrderItem> OrderItem = new ArrayList<OrderItem>();
            OrderItem.add(new OrderItem(ps2));
            OrderItem.add(new OrderItem(xbox));
            OrderItem.add(new OrderItem(maxSteel));
            Order order = new Order(OrderItem, status);

            orderRepository.save(order);

            Product pistaHotWheels = new Product("Pista Hot Wheels");
            order.getOrderItems().add(new OrderItem(pistaHotWheels));
            orderRepository.save(order);

            var orderReturn = orderRepository.findById(order.getId());
            if(orderReturn.isPresent())
            {
                var orderItemsReturn = orderItemsRepository.findAll();
                if(orderItemsReturn
                        .stream()
                        .filter(x -> x.getProduct() != null)
                        .anyMatch(x -> x.getProduct().getName().equals("Pista Hot Wheels")))
                    Printer.updateSuccess();
                else
                    Printer.updateFailure();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            Product nswitch = new Product("Nintendo Switch");
            Product wii = new Product("Nintendo Wii");
            Product funko = new Product("Funko");
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
