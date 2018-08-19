package com.exxeta.maau.tutorialmaau.controller;

import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.model.Factory;
import com.exxeta.maau.tutorialmaau.model.request.AddFactoryRequest;
import com.exxeta.maau.tutorialmaau.repository.CarRepository;
import com.exxeta.maau.tutorialmaau.repository.FactoryRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    private FactoryRepository factoryRepository;
    private CarRepository carRepository;

    public FactoryController(FactoryRepository factoryRepository, CarRepository carRepository){

        this.factoryRepository = factoryRepository;
        this.carRepository = carRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Factory> getAllFactories(){
        return factoryRepository.findAll();
    }



    @RequestMapping(value = "/create",  method = RequestMethod.POST)
    public void addFactory(@RequestBody AddFactoryRequest addFactoryRequest){
        Factory factory = new Factory();
        factory.setAcceptedType(addFactoryRequest.getAcceptedType());
        factory.setLocation(addFactoryRequest.getLocation());

        factoryRepository.save(factory);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteFactory(@PathVariable("id") Long factoryId){

        factoryRepository.deleteById(factoryId);
    }



    @RequestMapping(value = "/{factoryId}/getCars", method = RequestMethod.GET)
    public List<Car> getCarsByFactoryId(@PathVariable (value = "factoryId") Long factoryId){
        return carRepository.findByFactoryId(factoryId);
    }


}
