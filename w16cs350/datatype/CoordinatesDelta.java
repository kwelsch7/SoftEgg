package w16cs350.datatype;

public class CoordinatesDelta {
    private double x;
    private double y;

    public CoordinatesDelta(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CoordinatesDelta add(CoordinatesDelta coordinates) {
        // Adds delta coordinates to this one and returns a new one with the sum.
        return null;
    }

    public Angle calculateBearing(CoordinatesDelta target) {
        // Calculates the angle from these coordinates to another.
        return null;
    }

    public double calculateDistance(CoordinatesDelta target) {
        // Calculates the distance from these coordinates to another.
        return 0.0;
    }

    public CoordinatesDelta calculateTarget(Angle bearing, double distance) {
        // Calculates the target coordinates that lie at a given distance and angle from these coordinates.
        return null;
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }

    public CoordinatesDelta subtract(CoordinatesDelta coordinates) {
        // Subtracts delta coordinates from this one and returns a new one with the difference.
        return null;
    }

    public String toString() { return "X:" + this.x + ",Y:" + this.y; }
}
