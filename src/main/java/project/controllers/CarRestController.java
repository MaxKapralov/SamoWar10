package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.model.data.Car;
import project.model.data.CarInfo;
import project.model.repositories.CarInfoRepository;
import project.model.repositories.CarRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarRestController {

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

    @GetMapping(path = "/cars")
    public ResponseEntity<List<Car>> getListOfCars()
    {
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.findAll());
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
