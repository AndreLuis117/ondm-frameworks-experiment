package br.edu.univille.tcc.ondm.document.service;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.artemis.DatabaseQualifier;
import br.edu.univille.tcc.ondm.model.Car;
import br.edu.univille.tcc.ondm.model.Motor;
import br.edu.univille.tcc.ondm.repository.CarRepository;

public class CompositionTestsService implements ServiceBase{

    public CompositionTestsService(){
        this.container = SeContainerInitializer.newInstance().initialize();
        this.carRepository = this.container.select(CarRepository.class)
                .select(DatabaseQualifier.ofDocument()).get();
    }

    SeContainer container;
    CarRepository carRepository;

    @Override
    public void Insert() {

        try{
            Car car = new Car("Celta", new Motor(70.0));

            this.carRepository.save(car);

            if(this.carRepository.existsById(car.getId()))
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

            this.carRepository.save(car);

            var carReturn = this.carRepository.findAll();

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

            this.carRepository.save(car);

            var newMotor = car.getMotor();

            newMotor.setPower(240.0);

            car.setMotor(newMotor);

            this.carRepository.save(car);

            var carReturn = this.carRepository.findById(car.getId());

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

            this.carRepository.save(car);

            this.carRepository.deleteById(car.getId());

            if(!this.carRepository.existsById(car.getId()))
                System.out.println("Objeto deletado com sucesso!");
            else
                System.out.println("Objeto não foi deletado");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
