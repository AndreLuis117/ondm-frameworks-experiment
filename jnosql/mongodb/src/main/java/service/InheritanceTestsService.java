package service;

import model.Car;
import model.Dog;
import model.Motor;
import org.jnosql.artemis.DatabaseQualifier;
import repository.DogRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class InheritanceTestsService implements ServiceBase {

    public InheritanceTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        dogRepository = container.select(DogRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    DogRepository dogRepository;


    @Override
    public void Insert() {

        try{
            Dog dog = new Dog("Dogmeat", "Canis familiaris");

            dogRepository.save(dog);

            if(dogRepository.existsById(dog.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Select() {

        try{
            Dog dog = new Dog("Chop", "Canis familiaris");

            dogRepository.save(dog);

            var dogReturn = dogRepository.findById(dog.getId());

            if (dogReturn.isPresent())
                System.out.println("Objeto recuperado do banco de dados!");
            else
                System.out.println("O objeto não foi recuperado do banco de dados.");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Update() {

        try{
            Dog dog = new Dog("Chop", "Canis familiaris");

            dogRepository.save(dog);

            dog.setSpecies("Canis familiaris");
            dog.setName("Boomer");
            dogRepository.save(dog);

            var dogReturn = dogRepository.findById(dog.getId());

            if(dogReturn.get().getName().equals(dog.getName()) && dogReturn.get().getSpecies().equals(dog.getSpecies()))
                System.out.println("Objeto atualizado com sucesso!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Delete() {

        try{
            Dog dog = new Dog("D-Dog", "Canis familiaris");

            dogRepository.save(dog);

            dogRepository.deleteById(dog.getId());

            if(!dogRepository.existsById(dog.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
