package com.teclogi.app.Models;

import javax.persistence.Entity;

@Entity
public class Satellite {

    private String nameSatelite;
    private Double distance;

    //Setters y getters.
    public void setName(String name){
        this.nameSatelite = name;
    }

    public void setDistance(Double distance){
        this.distance = distance;
    }

    public String getName(){
        return this.nameSatelite;
    }

    public Double getDistance(){
        return this.distance;
    }
    
}

