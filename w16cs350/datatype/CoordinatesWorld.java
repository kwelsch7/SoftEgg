package w16cs350.datatype;

/*
    Defines coordinates in a world coordinate system of latitude and longitude.
    Only the Northern and Western Hemispheres are supported.
    The world is considered to be flat without distortion.
 */

public class CoordinatesWorld {
    //public static final CoordinatesWorld KGEG;
    //public static final CoordinatesWorld KSFF;
    //public static final CoordinatesWorld KSKA;
    public static final double METERS_PER_NAUTICAL_MILE = 1852.0;

    public CoordinatesWorld(Latitude latitude, Longitude longitude) {

    }

    public CoordinatesWorld add(CoordinatesWorld coordinates) {
        // Adds world coordinates to this one and returns a new one with the sum.
        return null;
    }

    public static CoordinatesWorld build(int latitudeDegrees,
                                         int latitudeMinutes,
                                         double latitudeSeconds,
                                         int longitudeDegrees,
                                         int longitudeMinutes,
                                         double longitudeSeconds) {
        // Builds coordinates based on the primitive arguments instead of the datatypes in the constructor.
        return null;
    }

    public Angle calculateBearing(CoordinatesWorld target) {
        // Calculates the angle from these coordinates to another.
        return null;
    }

    public double calculateDistanceMeters(CoordinatesWorld target) {
        // Calculates the distance in meters from these coordinates to another.
        return 0.0;
    }

    public double calculateDistanceNauticalMiles(CoordinatesWorld target) {
        // Calculates the distance in nautical miles from these coordinates to another.
        return 0.0;
    }

    public CoordinatesWorld calculateTarget(Angle bearing, double distance) {
        // Calculates the target coordinates that lie at a given distance and bearing from these coordinates.
        return null;
    }

    public CoordinatesWorld calculateTarget(CoordinatesDelta delta) {
        // Calculates the world coordinates the lie at a given offset from these coordinates.
        return null;
    }

    public static double convertMetersToNauticalMiles(double meters) {
        // Converts from meters to nautical miles.
        return 0.0;
    }

    public Latitude getLatitude() {
        return null;
    }

    public Longitude getLongitude() {
        return null;
    }

    public String getPrettyForm() {
        // Generates the string representation of this position from the pretty representations of the latitude and longitude.
        return "";
    }

    public CoordinatesWorld subtract(CoordinatesWorld coordinates) {
        // Subtracts world coordinates from this one and returns a new one with the difference.
        return null;
    }

    public String toString() { return ""; }

    public String toStringNMEA(boolean isHeaderRow) {
        /*
        Generates the NMEA string as follows:
        latitude.convertToNMEA(),longitude.convertToNMEA()
         */
        return "";
    }
}
