package com.teclogi.app.Models;

import java.util.List;

public class SatelliteRequest {
    
    private List<Satellite> satellites;

    //Setters y getters.
    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }
}
