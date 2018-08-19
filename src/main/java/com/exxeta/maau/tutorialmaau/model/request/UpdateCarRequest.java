package com.exxeta.maau.tutorialmaau.model.request;

import com.exxeta.maau.tutorialmaau.model.Factory;

public class UpdateCarRequest {

    private String type; //dropdown menu with 3 accepted types, when car is created
    private String vehicleClass;
    private String vehicleModel;
    private AddFactoryRequest addFactoryRequest;

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

    public AddFactoryRequest getAddFactoryRequest() {
        return addFactoryRequest;
    }

    public void setAddFactoryRequest(AddFactoryRequest addFactoryRequest) {
        this.addFactoryRequest = addFactoryRequest;
    }
}
