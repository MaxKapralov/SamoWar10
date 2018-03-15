package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Car> getListOfCars()
    {
        return carRepository.findAll();
    }

    @GetMapping(path = "/carsInfo")
    public List<CarInfo> getListOfCarsInfo()
    {
        return carInfoRepository.findAll();
    }
}
