package base.service;

import base.model.Address;
import base.model.Client;
import org.eclipse.jnosql.artemis.graph.GraphTemplate;
import repository.ClientRepository;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class AggregationTestsService implements ServiceBase{

    public AggregationTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        clientRepository = container.select(ClientRepository.class).get();
        graph = container.select(GraphTemplate.class).get();

    }

    SeContainer container;
    ClientRepository clientRepository;
    GraphTemplate graph;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try{
            Address address = new Address("Rio Negrinho", "Rua Marechal Teodoro", "SC", 178);
            Client client = new Client("John Marston", address);

            graph.insert(client);
            graph.insert(address);

            graph.edge(client, "has", address);

            var clientAddress = graph.getTraversalVertex().has("name", client.getName())
                                                                    .out("has").<Address>getResult()
                                                                    .findFirst();

            if(clientRepository.existsById(client.getId()) && clientAddress.isPresent())
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
            Address address = new Address("Joinville", "Rua da saudade", "SC", 898);
            Client client = new Client("Marco Reus", address);

            Address address2 = new Address("Campo Alegre", "Rua General Osvaldo", "SC", 1009);
            Client client2 = new Client("Arthur Morgan", address2);

            Address address3 = new Address("Blumenau", "Rua João das Neves", "SC", 980);
            Client client3 = new Client("Keanu Reeves", address3);

            graph.insert(client);
            graph.insert(client2);
            graph.insert(client3);

            graph.insert(address);
            graph.insert(address2);
            graph.insert(address3);

            graph.edge(client, "has", address);
            graph.edge(client2, "has", address2);
            graph.edge(client3, "has", address3);


            var clientReturn = clientRepository.findAll();

            if(!clientReturn.isEmpty()){
                Printer.selectSuccess();
                System.out.println("Clientes:");

                for (Client clientInDb : clientReturn)
                {
                    System.out.println(clientInDb.getName());

                    var clientAddress = graph.getTraversalVertex().has("name", clientInDb.getName())
                            .out("has").<Address>getResult()
                            .findFirst();
                    if(clientAddress.isPresent())
                        System.out.println("Endereço: " + clientAddress.toString());
                    else
                        System.out.println("Não foi possível encontrar o endereço do cliente.");
                }
            }else
                Printer.selectFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            Address address = new Address("Joinville", "Rua XV de novembro", "SC", 1100);
            Client client = new Client("Thomas A. Anderson", address);

            graph.insert(client);
            graph.insert(address);

            graph.edge(client, "has", address);

            var clientAddress = graph.getTraversalVertex(client.getId()).has("name", client.getName())
                    .out("has").<Address>getSingleResult();

            if (clientAddress.isPresent())
            {
                clientAddress.get().setPostalCode(1111);
                graph.insert(clientAddress.get());
            }

            var clientAddressUpdate = graph.getTraversalVertex(client.getId()).has("name", client.getName())
                    .out("has").<Address>getSingleResult();

            if(clientAddressUpdate.isPresent() && clientAddressUpdate.get().getPostalCode() == 1111)
                Printer.updateSuccess();
            else
                Printer.updateFailure();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try {
            Address address = new Address("Chapecó", "Rua João dos Santos", "SC", 460);
            Client client = new Client("John Wick", address);

            clientRepository.save(client);

            clientRepository.deleteById(client.getId());

            if(!clientRepository.existsById(client.getId()))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
