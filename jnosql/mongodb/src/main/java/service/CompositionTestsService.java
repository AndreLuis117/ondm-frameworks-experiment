package service;

import model.Address;
import model.Client;
import org.jnosql.artemis.DatabaseQualifier;
import repository.ClientRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CompositionTestsService implements ServiceBase{

    public CompositionTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        clientRepository = container.select(ClientRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    ClientRepository clientRepository;

    @Override
    public void insert() {

        try{
            Address address = new Address("Rio Negrinho", "Rua Marechal Teodoro", "SC", 178);
            Client client = new Client("John Marston", address);

            clientRepository.save(client);

            if(clientRepository.existsById(client.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

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

            var clientReturn = clientRepository.findAll();

            if(!clientReturn.isEmpty()){
                System.out.println("Objetos recuperados com sucesso!");
                System.out.println("Carros:");

                for (Client clientInDb : clientReturn)
                {
                    System.out.println(clientInDb.getName());
                }
            }else
                System.out.println("O objeto não foi recuperado do banco de dados.");

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
                System.out.println("Objeto atualizado com sucesso!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");

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
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
