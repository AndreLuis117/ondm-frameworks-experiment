package service;

import model.Status;
import org.jnosql.artemis.DatabaseQualifier;
import repository.StatusRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class NoRelationshipTestsService implements ServiceBase {

    public NoRelationshipTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        statusRepository = container.select(StatusRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    StatusRepository statusRepository;

    public void insert(){
        try {
            Status status = new Status("Aguardando pagamento");

            statusRepository.save(status);

            if(statusRepository.existsById(status.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try{
            Status status = new Status("Em separação");

            statusRepository.save(status);

            var statusReturn = statusRepository.findByName("Em separação");

            if(statusReturn != null)
                System.out.println(statusReturn.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(){

        try{
            Status status = new Status("Aguardando coleta da transportadora");

            statusRepository.save(status);

            statusRepository.deleteById(status.getId());

            if(!statusRepository.existsById(status.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(){

        try{
            Status status = new Status("Em transrte");

            statusRepository.save(status);

            status.setDescription("Em transporte");

            statusRepository.save(status);

            var movieReturn = statusRepository.findByName("Em transporte");

            if(movieReturn != null)
                System.out.println("Objeto atualizado no banco de dados!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
