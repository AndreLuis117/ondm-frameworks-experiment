package service;

import model.Address;
import model.Client;
import org.jnosql.artemis.DatabaseQualifier;
import repository.ClientRepository;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class AggregationTestsService implements ServiceBase{

    public AggregationTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        clientRepository = container.select(ClientRepository.class)
                .select(DatabaseQualifier.ofColumn()).get();
    }

    SeContainer container;
    ClientRepository clientRepository;

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

            clientRepository.save(client);

            if(clientRepository.existsById(client.getId()))
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

            clientRepository.save(client);
            clientRepository.save(client2);
            clientRepository.save(client3);

            var clientReturn = clientRepository.findAll();

            if(!clientReturn.isEmpty()){
                Printer.selectSuccess();
                System.out.println("Clientes:");

                for (Client clientInDb : clientReturn)
                {
                    System.out.println(clientInDb.getName());
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

            clientRepository.save(client);

            client.getAddress().setPostalCode(1111);

            clientRepository.save(client);

            var clientReturn = clientRepository.findById(client.getId());

            if(clientReturn.get().getAddress().getPostalCode() == client.getAddress().getPostalCode())
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
