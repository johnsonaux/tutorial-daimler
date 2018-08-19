package com.exxeta.maau.tutorialmaau.controller;


import com.exxeta.maau.tutorialmaau.exception.ResourceNotFoundException;
import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.model.request.AddCarRequest;
import com.exxeta.maau.tutorialmaau.repository.CarRepository;
import com.exxeta.maau.tutorialmaau.repository.FactoryRepository;
import com.exxeta.maau.tutorialmaau.services.CarService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private FactoryRepository factoryRepository;
    private CarRepository carRepository;


    public CarController (FactoryRepository factoryRepository, CarRepository carRepository){
        this.factoryRepository = factoryRepository;
        this.carRepository = carRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }


    @RequestMapping(value = "/{factoryId}/create", method = RequestMethod.POST)
    public Car addCarToFactory(@PathVariable (value = "factoryId") Long factoryId,
                                @RequestBody Car addCarRequest){

        return factoryRepository.findById(factoryId)
                .map(factory -> {
                    addCarRequest.setFactory(factory);
                    return carRepository.save(addCarRequest);
                }).orElseThrow(() -> new ResourceNotFoundException("Factory not found with id " + factoryId));
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
        carRepository.deleteById(carId);
    }

      /*
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addCar(@RequestBody AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setType(addCarRequest.getType());
        car.setVehicleClass(addCarRequest.getVehicleClass());
        car.setVehicleModel(addCarRequest.getVehicleModel());
        carService.addCar(car);
    }
    */


}
