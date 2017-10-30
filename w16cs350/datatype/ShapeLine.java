package w16cs350.datatype;

public class ShapeLine extends A_Shape {
    private double length;

    public ShapeLine(CoordinatesWorld reference,
                     CoordinatesDelta deltaStart,
                     CoordinatesDelta deltaEnd) {
        super(reference, deltaStart, deltaEnd);
        this.length = deltaStart.calculateDistance(deltaEnd);
    }

    public double getLength() {
        return this.length;
    }

    public CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB) {
        // Interpolates delta coordinates along the path.
        if (!isOnPath(distance)) {
            throw new RuntimeException();
        }
        Angle bearing = this.deltaStart.calculateBearing(this.deltaEnd);
        if(isFromAOrB) {
            return deltaStart.calculateTarget(bearing, distance);
        }
        else {
            return deltaEnd.calculateTarget(bearing, distance);
        }
    }

    public boolean isOnPath(double distance) {
        // Determines whether a point at a distance from either end of this shape within the limits.
        return distance <= this.length;
    }

    public String toString() { return "Reference:" + this.reference.toString(); }
}
