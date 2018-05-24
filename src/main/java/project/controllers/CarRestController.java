package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.data.AddNewCarForm;
import project.model.data.Car;
import project.model.data.CarInfo;
import project.model.data.CarServices;
import project.model.repositories.CarInfoRepository;
import project.model.repositories.CarRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarRestController {

    private CarRepository carRepository;
    private CarInfoRepository carInfoRepository;
    private CarServices carServices;

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

    @Autowired
    public void setCarServices(CarServices carServices){this.carServices = carServices;}

    @GetMapping(path = "/cars")
    public ResponseEntity<List<Car>> getListOfCars()
    {
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.findAll());
    }
    @GetMapping(path = "/car")
    public ResponseEntity<Car> getCarWithId(@RequestParam("id") Long id)
    {
        Car car = carRepository.findOne(id);
        if(car != null)
            return ResponseEntity.status(HttpStatus.OK).body(car);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping(path = "/carInfo")
    public ResponseEntity<CarInfo> getCarInfoWithId(@RequestParam("id") Long id)
    {
        CarInfo car = carInfoRepository.findOne(id);
        if(car != null)
            return ResponseEntity.status(HttpStatus.OK).body(car);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping(path = "/car")
    public ResponseEntity<Void> addNewCar(@RequestBody AddNewCarForm newCarForm)
    {
        return carServices.createNewCar(newCarForm);
    }

    @GetMapping(path = "/carsInfo")
    public ResponseEntity<List<CarInfo>> getListOfCarsInfo()
    {
        return ResponseEntity.status(HttpStatus.OK).body(carInfoRepository.findAll());
    }

    @GetMapping(path = "checkNumber")
    public ResponseEntity<Void> checkNumber(@RequestParam("number") String number)
    {
        CarInfo car = carInfoRepository.findByNumber(number);
        if(car == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
