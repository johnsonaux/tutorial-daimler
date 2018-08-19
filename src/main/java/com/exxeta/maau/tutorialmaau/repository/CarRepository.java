package com.exxeta.maau.tutorialmaau.repository;

import com.exxeta.maau.tutorialmaau.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByFactoryId(Long factoryId);
}
