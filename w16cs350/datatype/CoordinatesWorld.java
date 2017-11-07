/* Konnor Welsch - CS 350 */
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

    private Latitude latitude;
    private Longitude longitude;

    public CoordinatesWorld(Latitude latitude, Longitude longitude) {
        if(latitude == null || longitude == null) {
            throw new RuntimeException("Null object(s) passed to CoordinatesWorld constructor");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CoordinatesWorld add(CoordinatesWorld coordinates) {
        // Adds world coordinates to this one and returns a new one with the sum.
        if(coordinates == null) {
            throw new RuntimeException("Null coordinates passed to CoordinatesWorld.add");
        }
        Latitude newLatitude = this.latitude.add(coordinates.latitude);
        Longitude newLongitude = this.longitude.add(coordinates.longitude);
        return new CoordinatesWorld(newLatitude, newLongitude);
    }

    public static CoordinatesWorld build(int latitudeDegrees,
                                         int latitudeMinutes,
                                         double latitudeSeconds,
                                         int longitudeDegrees,
                                         int longitudeMinutes,
                                         double longitudeSeconds) {
        // Builds coordinates based on the primitive arguments instead of the datatypes in the constructor.
        Latitude latitude = new Latitude(latitudeDegrees, latitudeMinutes, latitudeSeconds);
        Longitude longitude = new Longitude(longitudeDegrees, longitudeMinutes, longitudeSeconds);
        return new CoordinatesWorld(latitude, longitude);
    }

    public Angle calculateBearing(CoordinatesWorld target) {
        // Calculates the angle from these coordinates to another.
        // REFERENCE: https://math.stackexchange.com/questions/1596513/find-the-bearing-angle-between-two-points-in-a-2d-space
        if(target == null) {
            throw new RuntimeException("Null target passed to CoordinatesWorld.calculateBearing");
        }
        double theta = Math.atan2((target.longitude.convertToNMEA() - this.longitude.convertToNMEA()), (target.latitude.convertToNMEA() - this.latitude.convertToNMEA()));
        return new Angle(Angle.normalize(Math.toDegrees(theta)));
    }

    public double calculateDistanceMeters(CoordinatesWorld target) {
        // Calculates the distance in meters from these coordinates to another.
        if(target == null) {
            throw new RuntimeException("Null target passed to CoordinatesWorld.calculateDistanceMeters");
        }
        return calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE;
    }

    public double calculateDistanceNauticalMiles(CoordinatesWorld target) {
        // Calculates the distance in nautical miles from these coordinates to another.
        if(target == null) {
            throw new RuntimeException("Null target passed to CoordinatesWorld.calculateDistanceNauticalMiles");
        }
        double longitudePortion = Math.pow((this.longitude.convertToNMEA() - target.longitude.convertToNMEA()), 2);
        double latitudePortion = Math.pow((this.latitude.convertToNMEA() - target.latitude.convertToNMEA()), 2);
        double sum = longitudePortion + latitudePortion;
        return Math.sqrt(sum);
    }

    public CoordinatesWorld calculateTarget(Angle bearing, double distance) {
        // Calculates the target coordinates that lie at a given distance and bearing from these coordinates.
        // REFERENCE: http://classroom.synonym.com/coordinates-distances-angles-2732.html
        if(bearing == null) {
            throw new RuntimeException("Null bearing passed to CoordinatesWorld.calculateTarget");
        }
        double angle = bearing.getValue();
        angle = Angle.normalize(angle); // if this doesn't work, try reciprocated
        double targetLongitude = this.longitude.convertToNMEA() + (Math.cos(angle) * distance);
        double targetLatitude = this.latitude.convertToNMEA() + (Math.sin(angle) * distance);
        return new CoordinatesWorld(new Latitude(targetLatitude), new Longitude(targetLongitude));
    }

    public CoordinatesWorld calculateTarget(CoordinatesDelta delta) {
        // Calculates the world coordinates the lie at a given offset from these coordinates.
        if(delta == null) {
            throw new RuntimeException("Null delta passed to CoordinatesWorld.calculateTarget");
        }
        double xNautical = delta.getX() / A_LatitudeLongitude.METERS_PER_NAUTICAL_MILE;
        double yNautical = delta.getY() / A_LatitudeLongitude.METERS_PER_NAUTICAL_MILE;
        return new CoordinatesWorld(new Latitude(yNautical + this.latitude.convertToNMEA()), new Longitude(xNautical - this.longitude.convertToNMEA()));
    }

    public static double convertMetersToNauticalMiles(double meters) {
        // Converts from meters to nautical miles.
        return meters / METERS_PER_NAUTICAL_MILE;
    }

    public Latitude getLatitude() { return this.latitude; }

    public Longitude getLongitude() { return this.longitude; }

    public String getPrettyForm() {
        // Generates the string representation of this position from the pretty representations of the latitude and longitude.
        return toString();
    }

    public CoordinatesWorld subtract(CoordinatesWorld coordinates) {
        // Subtracts world coordinates from this one and returns a new one with the difference.
        if(coordinates == null) {
            throw new RuntimeException("Null coordinates passed to CoordinatesWorld.subtract");
        }
        Latitude newLatitude = this.latitude.subtract(coordinates.latitude);
        Longitude newLongitude = this.longitude.subtract(coordinates.longitude);
        return new CoordinatesWorld(newLatitude, newLongitude);
    }

    public String toString() {
        return "Latitude: " + this.latitude.getDegrees() + "°" + this.latitude.getMinutes() + "'" + this.latitude.getSeconds() + "\""
                + " Longitude: " + this.longitude.getDegrees() + "°" + this.longitude.getMinutes() + "'" + this.longitude.getSeconds() + "\"";
    }

    public String toStringNMEA(boolean isHeaderRow) {
        /*
        Generates the NMEA string as follows:
        latitude.convertToNMEA(),longitude.convertToNMEA()
         */
        return "Latitude: " + latitude.convertToNMEA() + " Longitude: " + longitude.convertToNMEA();
    }
}
