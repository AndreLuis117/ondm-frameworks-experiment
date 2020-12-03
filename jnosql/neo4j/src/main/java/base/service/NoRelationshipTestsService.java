package base.service;

import base.model.Status;
import repository.StatusRepository;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class NoRelationshipTestsService implements ServiceBase {

    public NoRelationshipTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        statusRepository = container.select(StatusRepository.class).get();
    }

    SeContainer container;
    StatusRepository statusRepository;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    public void insert(){
        try {
            Status status = new Status("Aguardando pagamento");

            statusRepository.save(status);

            if(statusRepository.existsById(status.getId()))
                Printer.insertSuccess();
            else
                Printer.insertFailure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try{
            Status status = new Status("Em separação");

            statusRepository.save(status);

            var statusReturn = statusRepository.findByName(status.getName());

            if(statusReturn != null){
                Printer.selectSuccess();
                System.out.println("Status: ");
                System.out.println(statusReturn.getName());
            }else{
                Printer.selectFailure();
            }

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
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(){

        try{
            Status status = new Status("Em transrte");

            statusRepository.save(status);

            status.setName("Em transporte");

            statusRepository.save(status);

            var movieReturn = statusRepository.findById(status.getId());


            if(movieReturn.get().getName().equals(status.getName()))
                Printer.updateSuccess();
            else
                Printer.updateFailure();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
