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
        Car car = new Car("Celta", new Motor(70.0));

        carRepository.save(car);

    }

    @Override
    public void Select() {
        Car car = new Car("Ford KA", new Motor(72.0));

        carRepository.save(car);

        var carReturn = carRepository.findAll();

        for (Car carInDb : carReturn)
        {
            System.out.println(carInDb.getName());
        }
    }

    @Override
    public void Update() {
        Car car = new Car("Monza", new Motor(100.5));

        carRepository.save(car);

        var newMotor = car.getMotor();

        newMotor.setPower(240.0);

        car.setMotor(newMotor);

        carRepository.save(car);
    }

    @Override
    public void Delete() {
        Car car = new Car("Renault Clio", new Motor(70.2));

        carRepository.save(car);

        carRepository.deleteById(car.getId());
    }
}
