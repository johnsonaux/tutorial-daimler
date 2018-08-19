package com.exxeta.maau.tutorialmaau.controller;

import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.model.Factory;
import com.exxeta.maau.tutorialmaau.model.request.AddFactoryRequest;
import com.exxeta.maau.tutorialmaau.repository.FactoryRepository;
import com.exxeta.maau.tutorialmaau.services.CarService;
import com.exxeta.maau.tutorialmaau.services.FactoryService;
import org.omg.CORBA.Request;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    private FactoryService factoryService;
    private CarService carService;

    public FactoryController(FactoryService factoryService, CarService carService){
        this.factoryService = factoryService;
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Factory> getAllFactories(){
        return factoryService.getAllFactories();
    }



    @RequestMapping(value = "/create",  method = RequestMethod.POST)
    public void addFactory(@RequestBody AddFactoryRequest addFactoryRequest){
        Factory factory = new Factory();
        factory.setAcceptedType(addFactoryRequest.getAcceptedType());
        factory.setLocation(addFactoryRequest.getLocation());
        //one List of cars - addFactory adds new factory, therefore add empty List, method addCar required
        //factory.setCars();
        factoryService.addFactory(factory);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteFactory(@PathVariable("id") Long id){
        factoryService.deleteFactory(id);
    }

    @RequestMapping(value = "/getCars/{factoryId}")
    public List<Car> getFactoryCars(@PathVariable (value = "factoryId") Long factotyId){
        List<Car> allCars = carService.getAllCars();
        List<Car> carsInFactory = new ArrayList<>();
        for (Car car : allCars){
            if (car.getFactory().getId() == factotyId){
                carsInFactory.add(car);
            }
        }
        return carsInFactory;
    }


}
