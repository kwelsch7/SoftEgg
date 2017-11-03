/* Konnor Welsch - CS 350 */
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
        // https://math.stackexchange.com/questions/2045174/how-to-find-a-point-between-two-points-with-given-distance
        if (!isOnPath(distance)) {
            throw new RuntimeException();
        }

        double totalDistance = this.deltaStart.calculateDistance(this.deltaEnd);
        double xPortion, yPortion;
        if (isFromAOrB) {
            xPortion = this.deltaStart.getX() + distance / totalDistance * (this.deltaEnd.getX() - this.deltaStart.getX());
            yPortion = this.deltaStart.getY() + distance / totalDistance * (this.deltaEnd.getY() - this.deltaStart.getY());
        }
        else {
            xPortion = this.deltaEnd.getX() + distance / totalDistance * (this.deltaStart.getX() - this.deltaEnd.getX());
            yPortion = this.deltaEnd.getY() + distance / totalDistance * (this.deltaStart.getY() - this.deltaEnd.getY());
        }
        return new CoordinatesDelta(xPortion, yPortion);
    }

    public boolean isOnPath(double distance) {
        // Determines whether a point at a distance from either end of this shape within the limits.
        return distance <= this.length;
    }

    public String toString() { return "Reference:" + this.reference.toString(); }
}
