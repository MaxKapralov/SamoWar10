package project.model.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.model.repositories.CarInfoRepository;
import project.model.repositories.CarRepository;

/**
 * Created by Maksim Kapralov on 5/24/2018.
 */
@Service
public class CarServices {
    private CarRepository carRepository;
    private CarInfoRepository carInfoRepository;

    @Autowired
    public void setCarRepository(CarRepository repository)
    {
        this.carRepository = repository;
    }

    @Autowired
    public void setCarInfoRepository(CarInfoRepository repository)
    {
        this.carInfoRepository = repository;
    }

    public ResponseEntity<Void> createNewCar(AddNewCarForm newCarForm)
    {
        Car car = carRepository.save(new Car(newCarForm.getBrand(), newCarForm.getModel()));
        CarInfo info = carInfoRepository.save(new CarInfo(car.getId(), newCarForm.getNumber(), newCarForm.getNumOfPass(), newCarForm.getFuelConsumption(), newCarForm.getEngineVol(), newCarForm.hasConditioner(), newCarForm.getInterior(), newCarForm.getType(), newCarForm.getCost()));
        if(info != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
