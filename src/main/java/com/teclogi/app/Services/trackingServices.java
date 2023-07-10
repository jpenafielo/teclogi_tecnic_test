package com.teclogi.app.Services;


import java.awt.geom.Point2D;
import com.teclogi.app.Models.Position;
import com.teclogi.app.Models.Truck;

public class trackingServices {
    

    public Truck getLocation( Double sputnikDistance, Double explorerDistance, Double asterixDistance ){

        
        Truck dataTruck = new Truck();
        Boolean isValidData = true;
        Position locationTruck = new Position();

        Point2D.Double sputnik = new Point2D.Double(-500, -200);
        Point2D.Double explorer = new Point2D.Double(100, -100);
        Point2D.Double asterix = new Point2D.Double(500, 100);

        
        Point2D.Double vehiclePosition;

        if (sputnikDistance <= 0 || explorerDistance <= 0 || asterixDistance <= 0) {
            isValidData = false;          
        }
        
        
        if (isValidData) {

            vehiclePosition = triangulatePosition (sputnik, explorer, asterix, sputnikDistance, explorerDistance, asterixDistance);
            locationTruck.setX(vehiclePosition.x);
            locationTruck.setY(vehiclePosition.y);

            dataTruck.setPosition(locationTruck);
            dataTruck.setisInDanger(true);
        }
        

        

        return dataTruck;
    }

   private static Point2D.Double triangulatePosition(Point2D.Double sputnik, Point2D.Double explorer,
                                                     Point2D.Double asterix, double distanceToSputnik,
                                                     double distanceToExplorer, double distanceToAsterix) {

        double x1 = sputnik.x;
        double y1 = sputnik.y;
        double x2 = explorer.x;
        double y2 = explorer.y;
        double x3 = asterix.x;
        double y3 = asterix.y;

        double d12 = distanceToSputnik;
        double d23 = distanceToExplorer;
        double d31 = distanceToAsterix;

        double A = 2 * x2 - 2 * x1;
        double B = 2 * y2 - 2 * y1;
        double C = Math.pow(d12, 2) - Math.pow(d23, 2) - Math.pow(x1, 2) + Math.pow(x2, 2) - Math.pow(y1, 2) + Math.pow(y2, 2);
        double D = 2 * x3 - 2 * x2;
        double E = 2 * y3 - 2 * y2;
        double F = Math.pow(d23, 2) - Math.pow(d31, 2) - Math.pow(x2, 2) + Math.pow(x3, 2) - Math.pow(y2, 2) + Math.pow(y3, 2);

        double x = (C * E - F * B) / (E * A - B * D);
        double y = (C * D - A * F) / (B * D - A * E);

        return new Point2D.Double(x, y);
    }

    

}
