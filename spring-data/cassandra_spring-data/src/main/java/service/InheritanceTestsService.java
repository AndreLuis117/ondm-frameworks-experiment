package service;

import model.Electronic;
import repository.ElectronicRepository;
import utilities.Printer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class InheritanceTestsService implements ServiceBase {

    public InheritanceTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        electronicRepository = container.select(ElectronicRepository.class).get();
    }

    SeContainer container;
    ElectronicRepository electronicRepository;

    public void runAll(){
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        try{
            Electronic electronic = new Electronic("Xbox One X", 220);

            electronicRepository.save(electronic);

            if(electronicRepository.existsById(electronic.getId()))
                Printer.insertSuccess();
            else
                Printer.insertFailure();

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
                Printer.selectSuccess();
            else
                Printer.selectFailure();


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
            Electronic electronic = new Electronic("TV SAMSUNG 4K RU7100", 220);

            electronicRepository.save(electronic);

            electronicRepository.deleteById(electronic.getId());

            if(!electronicRepository.existsById(electronic.getId()))
                Printer.deleteSuccess();
            else
                Printer.deleteFailure();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
