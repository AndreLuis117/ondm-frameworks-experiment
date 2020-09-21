package service;

import model.Order;
import model.OrderItems;
import org.jnosql.artemis.DatabaseQualifier;
import repository.MovieRepository;
import repository.OrderRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AggregationTestsService implements ServiceBase {

    public AggregationTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        orderRepository = container.select(OrderRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }
    SeContainer container;

    //Injetando o repositório
    OrderRepository orderRepository;

    @Override
    public void Insert() {
        List<OrderItems> orderItems = new ArrayList<OrderItems>();
        orderItems.add(new OrderItems("Xbox one"));
        orderItems.add(new OrderItems("Ps4"));
        orderItems.add(new OrderItems("Nintendo Switch"));
        Order order = new Order(orderItems);

        orderRepository.save(order);

    }

    @Override
    public void Select() {
        List<OrderItems> orderItems = new ArrayList<OrderItems>();
        orderItems.add(new OrderItems("GTA V"));
        orderItems.add(new OrderItems("Mafia 3"));
        orderItems.add(new OrderItems("Forza Horizon 3"));
        orderItems.add(new OrderItems("Skate 3"));
        Order order = new Order(orderItems);

        orderRepository.save(order);
        
        Optional<Order> orderReturn = orderRepository.findById(order.getId());

        for (OrderItems orderItem : orderReturn.get().getOrderItem())
        {
            System.out.println(orderItem.getProduct());
        }
    }

    @Override
    public void Update() {
        List<OrderItems> orderItems = new ArrayList<OrderItems>();
        orderItems.add(new OrderItems("Caneta"));
        orderItems.add(new OrderItems("Caderno"));
        orderItems.add(new OrderItems("Lápis"));
        orderItems.add(new OrderItems("Estojo"));
        Order order = new Order(orderItems);

        orderRepository.save(order);

        order.getOrderItem().add(new OrderItems("Mochila"));

        orderRepository.save(order);
    }

    @Override
    public void Delete() {
        List<OrderItems> orderItems = new ArrayList<OrderItems>();
        orderItems.add(new OrderItems("TV SAMSUNG"));
        orderItems.add(new OrderItems("TV LG"));
        orderItems.add(new OrderItems("TV SONY"));
        orderItems.add(new OrderItems("TV AOC"));
        Order order = new Order(orderItems);

        orderRepository.save(order);

        orderRepository.deleteById(order.getId());
    }

}
