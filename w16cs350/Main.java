package w16cs350;

import w16cs350.datatype.*;

public class Main {

    public static void main(String[] args) {
        CoordinatesDelta coordinatesDelta = new CoordinatesDelta(10, 20);
        Angle angle = new Angle(45);

        CoordinatesDelta target = coordinatesDelta.calculateTarget(angle, 28.284271247461902);

        System.out.println(target);


//        Latitude latitude = new Latitude(115.45);
//        Longitude longitude = new Longitude(314.56);
//        CoordinatesWorld world = new CoordinatesWorld(latitude, longitude);
//        Angle angle = new Angle(60);
//
//        CoordinatesWorld target = world.calculateTarget(angle, 28.284271247461902);
//        System.out.println(target.toStringNMEA(true));
    }
}
