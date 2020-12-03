package base.service;

import base.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.OrderRepository;
import utilities.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompositionTestsService implements ServiceBase {

    public CompositionTestsService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        orderRepository = context.getBean(OrderRepository.class);
    }

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


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(xbox360));
            orderItems.add(new OrderItems(ps3));
            orderItems.add(new OrderItems(funko));
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


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(xboxOne));
            orderItems.add(new OrderItems(ps4));
            orderItems.add(new OrderItems(hotwheels));
            Order order = new Order(orderItems, status);

            orderRepository.save(order);

            Optional<Order> orderReturn = orderRepository.findById(order.getId());

            if(orderReturn.isPresent()){
                Printer.selectSuccess();
                System.out.println("Itens:");

                for (OrderItems orderItem : orderReturn.get().getOrderItems())
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


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(ps2));
            orderItems.add(new OrderItems(xbox));
            orderItems.add(new OrderItems(maxSteel));
            Order order = new Order(orderItems, status);

            orderRepository.save(order);
            Toy pistaHotWheels = new Toy("Pista Hot Wheels", 5);
            order.getOrderItems().add(new OrderItems(pistaHotWheels));
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


            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems(nswitch));
            orderItems.add(new OrderItems(wii));
            orderItems.add(new OrderItems(funko));
            Order order = new Order(orderItems, status);

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
