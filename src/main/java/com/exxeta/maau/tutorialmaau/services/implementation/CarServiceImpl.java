package com.exxeta.maau.tutorialmaau.services.implementation;

import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.repository.CarRepository;
import com.exxeta.maau.tutorialmaau.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
        /*
        if(carRepository.existsById(carId)){
            carRepository.deleteById(carId);
        }
        */

    }

    public Optional updateCar(Long carId){
        //add car to factory
        //if car type equals accepted type
        Optional car = carRepository.findById(carId);
        return car;
    }
}
