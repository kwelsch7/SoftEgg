/* Konnor Welsch - CS 350 */
package w16cs350.datatype;

/*
    Defines latitude encoded in NMEA 0183 format. It works only in the Northern Hemisphere.
    For example, Spokane International Airport lies roughly at 47°37'8".
 */

public class Latitude extends A_LatitudeLongitude {
    // Inherits the static stuff from A_LatitudeLongitude

    public Latitude(double nmea) {
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
    }

    public Latitude(int degrees, int minutes, double seconds) {
        super(degrees, minutes, seconds);
    }

    public Latitude add(Latitude latitude) {
        // Adds a latitude to this one and returns a new one with the sum.
        if(latitude == null) {
            throw new RuntimeException("Null latitude passed to Latitude.add");
        }
        int newDegrees = this.degrees + latitude.degrees;
        int newMinutes = this.minutes + latitude.minutes;
        double newSeconds = this.seconds + latitude.seconds;
        return new Latitude(newDegrees, newMinutes, newSeconds);
    }

    public int compareTo(Latitude latitude) {
        if(latitude == null) {
            throw new RuntimeException("Null latitude passed to Latitude.compareTo");
        }
        return super.compareTo(latitude);
    }

    public Latitude subtract(Latitude latitude) {
        // Subtracts a latitude from this one and returns a new one with the difference.
        if(latitude == null) {
            throw new RuntimeException("Null latitude passed to Latitude.subtract");
        }
        int newDegrees = this.degrees - latitude.degrees;
        int newMinutes = this.minutes - latitude.minutes;
        double newSeconds = this.seconds - latitude.seconds;
        return new Latitude(newDegrees, newMinutes, newSeconds);
    }

    public String toString() { return super.toString(); }
}
