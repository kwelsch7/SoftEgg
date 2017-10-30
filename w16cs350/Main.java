package w16cs350;

import w16cs350.datatype.*;

public class Main {

    public static void main(String[] args) {
        Latitude latitude = new Latitude(12345.6);
        Longitude longitude = new Longitude(12345.6);
        CoordinatesDelta coordinatesDelta = new CoordinatesDelta(15.0, 0.0);
        CoordinatesWorld coordinatesWorld = new CoordinatesWorld(latitude, longitude);
        CoordinatesScreen coordinatesScreen = new CoordinatesScreen(6, 70);
        Angle angle = new Angle(75.0);
        ShapeLine shapeLine = new ShapeLine(coordinatesWorld, coordinatesDelta, coordinatesDelta);
    }
}
