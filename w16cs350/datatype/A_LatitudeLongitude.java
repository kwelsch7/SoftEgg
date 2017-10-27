package w16cs350.datatype;

/*
    Defines the shared elements of latitude and longitude encoded in NMEA 0183 format.
    The equation is NMEA = ((degrees * 100) + minutes + (seconds / 60)).
    The world is considered to be flat without distortion.
 */

public abstract class A_LatitudeLongitude implements Comparable<A_LatitudeLongitude> {
    public static final double METERS_PER_NAUTICAL_MILE = 1852.0;
    public static final int MINUTES_PER_DEGREE = 60;
    public static final int SECONDS_PER_MINUTE = 60;

    protected int degrees;
    protected int minutes;
    protected double seconds;

    public A_LatitudeLongitude(int degrees, int minutes, double seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public double calculateDistanceMeters(A_LatitudeLongitude target) {
        // Calculates the the distance in meters between these coordinates and a target.
        return 0.0;
    }

    public double calculateDistanceNauticalMiles(A_LatitudeLongitude target) {
        // Calculates the the distance in nautical miles between these coordinates and a target.
        return 0.0;
    }

    public int compareTo(A_LatitudeLongitude coordinates) {
        // Compares these coordinates to another by NMEA encoding to the thousandths place.
        return 0;
    }

    public static int convertToDegrees(double nmea) {
        // Extracts the degrees component of a NMEA encoding.
        return 0;
    }

    public static int convertToMinutes(double nmea) {
        // Extracts the minutes component of a NMEA encoding.
        return 0;
    }

    public static double convertToNauticalMiles(int degrees, int minutes, double seconds) {
        // Converts a DMS encoding to NMEA.
        return 0.0;
    }

    public double convertToNMEA() {
        // Converts this position to NMEA encoding.
        return 0.0;
    }

    public static double convertToNMEA(int degrees, int minutes, double seconds) {
        // Converts a DMS encoding to NMEA.
        return 0.0;
    }

    public static double convertToSeconds(double nmea) {
        // Extracts the seconds component of a NMEA encoding.
        return 0.0;
    }

    public boolean equals(Object coordinates) {
        // Compares these coordinates to another.
        return false;
    }

    public int getDegrees() {
        // Gets the degrees component.
        return 0;
    }

    public int getMinutes() {
        // Gets the minutes component.
        return 0;
    }

    public String getPrettyForm() {
        // Generates the string representation of this position.
        return "";
    }

    public double getSeconds() {
        // Gets the seconds component.
        return 0.0;
    }

    public int hashCode() {
        // Computes the hash code for these coordinates.
        return 0;
    }

    public String toString() {
        return "";
    }
}
