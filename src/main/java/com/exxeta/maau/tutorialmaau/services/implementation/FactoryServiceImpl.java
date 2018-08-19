package com.exxeta.maau.tutorialmaau.services.implementation;

import com.exxeta.maau.tutorialmaau.model.Car;
import com.exxeta.maau.tutorialmaau.model.Factory;
import com.exxeta.maau.tutorialmaau.repository.FactoryRepository;
import com.exxeta.maau.tutorialmaau.services.FactoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

    private FactoryRepository factoryRepository;

    public FactoryServiceImpl(FactoryRepository factoryRepository){
        this.factoryRepository = factoryRepository;
    }

    public List<Factory> getAllFactories() {
        return factoryRepository.findAll();
    }

    public void addFactory(Factory factory) {
        factoryRepository.save(factory);
    }

    public List<Car> getCarsInFactory(Long factoryId) {
        return null;
    }

    public void deleteFactory(Long factoryId) {
        factoryRepository.deleteById(factoryId);
    }
}
