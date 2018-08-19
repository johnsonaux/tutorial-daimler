package com.exxeta.maau.tutorialmaau.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String type;

    private String vehicleClass;

    private String vehicleModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "factory_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Factory factory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}