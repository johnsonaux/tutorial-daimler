package com.exxeta.maau.tutorialmaau.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Factory {


    @Id
    @GeneratedValue
    private Long id;


    private String acceptedType;


    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcceptedType() {
        return acceptedType;
    }

    public void setAcceptedType(String acceptedType) {
        this.acceptedType = acceptedType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
