package com.teclogi.app.Models;
import javax.persistence.Entity;

@Entity
public class Truck {

    private Position position;

    private Boolean isInDanger;

    public void setPosition(Position position){
        this.position = position;

    }

    public void setisInDanger(Boolean isInDanger){
        this.isInDanger = isInDanger;
        
    }

    public Position getPosition(){
        return this.position;
        
    }

    public Boolean getisInDanger(){
        return this.isInDanger;
        
    }



    
}
