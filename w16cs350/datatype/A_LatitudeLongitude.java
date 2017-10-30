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
        return calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE;
    }

    public double calculateDistanceNauticalMiles(A_LatitudeLongitude target) {
        // Calculates the the distance in nautical miles between these coordinates and a target.
        // Note: 1 nautical mile == 1 minute
        double degreeMinutes = (this.degrees - target.degrees) * MINUTES_PER_DEGREE;
        double distanceMinutes = this.minutes - target.minutes;
        double secondMinutes = (this.seconds - target.seconds) / SECONDS_PER_MINUTE;
        double totalMinutes = degreeMinutes + distanceMinutes + secondMinutes;
        return totalMinutes;
    }

    public int compareTo(A_LatitudeLongitude coordinates) {
        // Compares these coordinates to another by NMEA encoding to the thousandths place.
        // This method is not required
        int result = this.degrees - coordinates.degrees;
        if (result == 0) {
            result = this.minutes = coordinates.minutes;
            if (result == 0) {
                result = (int)(this.seconds * 1000) - (int)(coordinates.seconds * 1000);
            }
        }
        return result;
    }

    public static int convertToDegrees(double nmea) {
        // Extracts the degrees component of a NMEA encoding.
        return (int)(nmea / 100);
    }

    public static int convertToMinutes(double nmea) {
        // Extracts the minutes component of a NMEA encoding.
        return (int)(nmea % 100);
    }

    public static double convertToNauticalMiles(int degrees, int minutes, double seconds) {
        // Converts a DMS encoding to NMEA.
        // NOT IMPLEMENTING
        return 0.0;
    }

    public double convertToNMEA() {
        // Converts this position to NMEA encoding.
        return convertToNMEA(this.degrees, this.minutes, this.seconds);
    }

    public static double convertToNMEA(int degrees, int minutes, double seconds) {
        // Converts a DMS encoding to NMEA.
        return ((degrees * 100) + minutes + (seconds / 60));
    }

    public static double convertToSeconds(double nmea) {
        // Extracts the seconds component of a NMEA encoding.
        return (nmea % 1) * 60;
    }

    public boolean equals(Object coordinates) {
        // Compares these coordinates to another.
        // This method is not required
        if (!(coordinates instanceof A_LatitudeLongitude)) {
            return false;
        }
        if (coordinates == this) {
            return true;
        }
        return this.degrees == ((A_LatitudeLongitude) coordinates).degrees
                && this.minutes == ((A_LatitudeLongitude) coordinates).minutes
                && this.seconds == ((A_LatitudeLongitude) coordinates).seconds;
    }

    public int getDegrees() { return this.degrees; }

    public int getMinutes() { return this.minutes; }

    public String getPrettyForm() {
        // Generates the string representation of this position.
        return toString();
    }

    public double getSeconds() { return this.seconds; }

    public int hashCode() {
        // Computes the hash code for these coordinates.
        return super.hashCode();
    }

    public String toString() {
        return this.degrees + "°" + this.minutes + "'" + this.seconds + "\"";
    }
}
