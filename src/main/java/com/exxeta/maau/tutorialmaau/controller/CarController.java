package com.exxeta.maau.tutorialmaau.controller;


import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.model.Factory;
import com.exxeta.maau.tutorialmaau.model.request.AddCarRequest;
import com.exxeta.maau.tutorialmaau.model.request.UpdateCarRequest;
import com.exxeta.maau.tutorialmaau.repository.CarRepository;
import com.exxeta.maau.tutorialmaau.repository.FactoryRepository;
import com.exxeta.maau.tutorialmaau.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    //private CarRepository carRepository;

    private CarService carService;
    private FactoryRepository factoryRepository;
    private CarRepository carRepository;

    /*
    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    */

    public CarController (CarService carService, FactoryRepository factoryRepository, CarRepository carRepository){
        this.carService = carService;
        this.factoryRepository = factoryRepository;
        this.carRepository = carRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }



    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addCar(@RequestBody AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setType(addCarRequest.getType());
        car.setVehicleClass(addCarRequest.getVehicleClass());
        car.setVehicleModel(addCarRequest.getVehicleModel());
        carService.addCar(car);
    }

    //Update
    @RequestMapping(value = "/update/{carId}/set/{factoryId}/", method = RequestMethod.PUT)
    public void addCarToFactory(@PathVariable (value = "carId") Long carId,
                                @PathVariable (value = "factoryId") Long factoryId,
                                @RequestBody AddCarRequest addCarRequest){
        carRepository.findById(carId).map(car -> {
            car.setType(addCarRequest.getType());
            car.setVehicleClass(addCarRequest.getVehicleClass());
            car.setVehicleModel(addCarRequest.getVehicleModel());
            factoryRepository.findById(factoryId).map(factory1 -> {
                car.setFactory(factory1);
                return factory1;
            });
            return carRepository.save(car);
        });


    }

    @RequestMapping(value = "/update/{carId}", method = RequestMethod.PUT)
    public void updateCar(@PathVariable (value= "carId") Long carId, @RequestBody AddCarRequest addCarRequest){
        carRepository.findById(carId).map(car -> {
            car.setType(addCarRequest.getType());
            car.setVehicleClass(addCarRequest.getVehicleClass());
            car.setVehicleModel(addCarRequest.getVehicleModel());
            return carRepository.save(car);
        });
    }

    @RequestMapping(value = "/delete/{carId}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("carId") Long carId){
        carService.deleteCar(carId);
    }


}
