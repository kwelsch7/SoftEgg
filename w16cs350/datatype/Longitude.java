package w16cs350.datatype;

/*
    Defines longitude encoded in NMEA 0183 format. It works only in the Western Hemisphere.
    For example, Spokane International Airport lies roughly at 117°32'14".
 */

public class Longitude extends A_LatitudeLongitude {
    // inherits all constants from A_LatitudeLongitude

    public Longitude(double nmea) {
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
    }

    public Longitude(int degrees, int minutes, double seconds) {
        super(degrees, minutes, seconds);
    }

    public Longitude add(Longitude longitude) {
        // Adds a longitude to this one and returns a new one with the sum.
        int newDegrees = this.degrees + longitude.degrees;
        int newMinutes = this.minutes + longitude.minutes;
        double newSeconds = this.seconds + longitude.seconds;
        return new Longitude(newDegrees, newMinutes, newSeconds);
    }

    public int compareTo(Longitude longitude) {
        return super.compareTo(longitude);
    }

    public Longitude subtract(Longitude longitude) {
        // Subtracts a longitude from this one and returns a new one with the difference.
        int newDegrees = this.degrees - longitude.degrees;
        int newMinutes = this.minutes - longitude.minutes;
        double newSeconds = this.seconds - longitude.seconds;
        return new Longitude(newDegrees, newMinutes, newSeconds);
    }

    public String toString() { return super.toString(); }
}
