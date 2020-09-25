package br.edu.univille.tcc.ondm.document.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.artemis.DatabaseQualifier;
import br.edu.univille.tcc.ondm.model.Order;
import br.edu.univille.tcc.ondm.model.OrderItems;
import br.edu.univille.tcc.ondm.repository.OrderRepository;

public class AggregationTestsService implements ServiceBase {

    public AggregationTestsService() {
        this.container = SeContainerInitializer.newInstance().initialize();
        this.orderRepository = this.container.select(OrderRepository.class).select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    OrderRepository orderRepository;

    @Override
    public void Insert() {

        try {
            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems("Xbox one"));
            orderItems.add(new OrderItems("Ps4"));
            orderItems.add(new OrderItems("Nintendo Switch"));
            Order order = new Order(orderItems);

            this.orderRepository.save(order);

            if (this.orderRepository.existsById(order.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Select() {

        try {
            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems("GTA V"));
            orderItems.add(new OrderItems("Mafia 3"));
            orderItems.add(new OrderItems("Forza Horizon 3"));
            orderItems.add(new OrderItems("Skate 3"));
            Order order = new Order(orderItems);

            this.orderRepository.save(order);

            Optional<Order> orderReturn = this.orderRepository.findById(order.getId());

            if (orderReturn.isPresent()) {
                System.out.println("Objeto recuperado do banco de dados!");
                System.out.println("Itens:");

                for (OrderItems orderItem : orderReturn.get().getOrderItem()) {
                    System.out.println(orderItem.getProduct());
                }
            } else
                System.out.println("O objeto não foi recuperado do banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Update() {

        try {
            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems("Caneta"));
            orderItems.add(new OrderItems("Caderno"));
            orderItems.add(new OrderItems("Lápis"));
            orderItems.add(new OrderItems("Estojo"));
            Order order = new Order(orderItems);

            this.orderRepository.save(order);
            var newOrderItem = new OrderItems("Mochila");
            order.getOrderItem().add(newOrderItem);
            this.orderRepository.save(order);

            var orderReturn = this.orderRepository.findById(order.getId());

            if (orderReturn.get().getOrderItem().stream().anyMatch(x -> x.getProduct().equals("Mochila")))
                System.out.println("O objeto foi atualizado com sucesso!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Delete() {

        try {
            List<OrderItems> orderItems = new ArrayList<OrderItems>();
            orderItems.add(new OrderItems("TV SAMSUNG"));
            orderItems.add(new OrderItems("TV LG"));
            orderItems.add(new OrderItems("TV SONY"));
            orderItems.add(new OrderItems("TV AOC"));
            Order order = new Order(orderItems);

            this.orderRepository.save(order);

            this.orderRepository.deleteById(order.getId());

            if (!this.orderRepository.existsById(order.getId()))
                System.out.println("O objeto foi deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
