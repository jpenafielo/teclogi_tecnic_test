package com.teclogi.app.Controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teclogi.app.Models.MoneyHouses;
import com.teclogi.app.Models.MoneyStolen;
import com.teclogi.app.Models.Satellite;
import com.teclogi.app.Models.SatelliteRequest;
import com.teclogi.app.Models.Truck;
import com.teclogi.app.Services.robServices;
import com.teclogi.app.Services.trackingServices;

@RestController
public class TestController {

    trackingServices trackingServices = new trackingServices();
    
    robServices robServices = new robServices();

    @GetMapping("/")
    String serverInitialized(){
        return "Server is running.";
    }

    //Llamada a la función getlocation cuando se realiza una petición http post a la ruta /tracking/
    @PostMapping("/tracking/")
    ResponseEntity<Truck> locationTruck(@RequestBody SatelliteRequest request ){


        
        List<Satellite> satelites = request.getSatellites(); 

        //Obtención de las distancias a partir de la lista de satelites obtenida en la petición
        Double sputnikDistance = satelites.get(0).getDistance();
        Double explorekDistance = satelites.get(1).getDistance();
        Double asterixDistance = satelites.get(2).getDistance();

        //Llamada a la función.
        Truck positionTruck = trackingServices.getLocation(sputnikDistance, explorekDistance, asterixDistance);

        //Si no es válido, es decir, la respuesta es nula, se responde un httpstatus 404.
        if (positionTruck.getPosition()==null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(positionTruck);

        } else{

            return ResponseEntity.ok(positionTruck);

        }
        
    }
    //Llamada a la función rob cuando se ejecuta una petición post a la ruta /rob/
    @PostMapping("/rob/")
    MoneyStolen moneyStolenRob(@RequestBody MoneyHouses request ){
        
        return robServices.rob(request.getMoney());

    }
    
}
