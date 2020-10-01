package service;

import model.Electronic;
import org.jnosql.artemis.DatabaseQualifier;
import repository.ElectronicRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class InheritanceTestsService implements ServiceBase {

    public InheritanceTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        electronicRepository = container.select(ElectronicRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    ElectronicRepository electronicRepository;


    @Override
    public void insert() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);

            electronicRepository.save(electronic);

            if(electronicRepository.existsById(electronic.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void select() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);

            electronicRepository.save(electronic);

            var electronicReturn = electronicRepository.findById(electronic.getId());

            if (electronicReturn.isPresent())
                System.out.println("Objeto recuperado do banco de dados!");
            else
                System.out.println("O objeto não foi recuperado do banco de dados.");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

        try{
            Electronic electronic = new Electronic("PS4", 110);

            electronicRepository.save(electronic);

            electronic.setVoltage(220);

            electronicRepository.save(electronic);

            var dogReturn = electronicRepository.findById(electronic.getId());

            if(dogReturn.get().getVoltage() == electronic.getVoltage())
                System.out.println("Objeto atualizado com sucesso!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        try{
            Electronic electronic = new Electronic("TV SAMSUNG 4K RU7100", 220);

            electronicRepository.save(electronic);

            electronicRepository.deleteById(electronic.getId());

            if(!electronicRepository.existsById(electronic.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
