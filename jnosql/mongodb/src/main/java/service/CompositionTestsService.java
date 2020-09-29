package service;

import model.Car;
import model.Motor;
import model.OrderItems;
import org.jnosql.artemis.DatabaseQualifier;
import repository.CarRepository;
import repository.OrderRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CompositionTestsService implements ServiceBase{

    public CompositionTestsService(){
        container = SeContainerInitializer.newInstance().initialize();
        carRepository = container.select(CarRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    CarRepository carRepository;

    @Override
    public void Insert() {

        try{
            Car car = new Car("Celta", new Motor(70.0));

            carRepository.save(car);

            if(carRepository.existsById(car.getId()))
                System.out.println("Objeto salvo no banco de dados com sucesso!");
            else
                System.out.println("O objeto não foi salvo no banco de dados.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Select() {

        try {
            Car car = new Car("Ford KA", new Motor(72.0));
            Car car2 = new Car("GOL G4", new Motor(80.0));
            Car car3 = new Car("POLO", new Motor(85.4));

            carRepository.save(car);

            var carReturn = carRepository.findAll();

            if(!carReturn.isEmpty()){
                System.out.println("Objetos recuperados com sucesso!");
                System.out.println("Carros:");

                for (Car carInDb : carReturn)
                {
                    System.out.println(carInDb.getName());
                }
            }else
                System.out.println("O objeto não foi recuperado do banco de dados.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Update() {

        try{
            Car car = new Car("Monza", new Motor(100.5));

            carRepository.save(car);

            var newMotor = car.getMotor();

            newMotor.setPower(240.0);

            car.setMotor(newMotor);

            carRepository.save(car);

            var carReturn = carRepository.findById(car.getId());

            if(carReturn.get().getMotor().getPower() == newMotor.getPower())
                System.out.println("Objeto atualizado com sucesso!");
            else
                System.out.println("O obejto não foi atualizado no banco de dados.");

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Delete() {

        try {
            Car car = new Car("Renault Clio", new Motor(70.2));

            carRepository.save(car);

            carRepository.deleteById(car.getId());

            if(!carRepository.existsById(car.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
