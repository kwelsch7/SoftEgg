/* Konnor Welsch - CS 350 */
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
        if(coordinates == null) {
            throw new RuntimeException("Null coordinates passed to CoordinatesDelta.add");
        }
        double newX = this.x + coordinates.x;
        double newY = this.y + coordinates.y;
        return new CoordinatesDelta(newX, newY);
    }

    public Angle calculateBearing(CoordinatesDelta target) {
        // Calculates the angle from these coordinates to another.
        // REFERENCE: https://math.stackexchange.com/questions/1596513/find-the-bearing-angle-between-two-points-in-a-2d-space
        if(target == null) {
            throw new RuntimeException("Null target passed to CoordinatesDelta.calculateBearing");
        }
        double theta = Math.atan2((target.x - this.x), (target.y - this.y));
        while (theta < 0.0) {
            theta += (Math.PI * 2);
        }
        return new Angle(Math.toDegrees(theta));
    }

    public double calculateDistance(CoordinatesDelta target) {
        // Calculates the distance from these coordinates to another.
        if(target == null) {
            throw new RuntimeException("Null target passed to CoordinatesDelta.calculateDistance");
        }
        double xPortion = Math.pow((this.x - target.x), 2);
        double yPortion = Math.pow((this.y - target.y), 2);
        double sum = xPortion + yPortion;
        return Math.sqrt(sum);
    }

    public CoordinatesDelta calculateTarget(Angle bearing, double distance) {
        // Calculates the target coordinates that lie at a given distance and angle from these coordinates.
        // REFERENCE: http://classroom.synonym.com/coordinates-distances-angles-2732.html
        if(bearing == null) {
            throw new RuntimeException("Null bearing passed to CoordinatesDelta.calculateTarget");
        }
        if (distance < 0.0) {
            throw new RuntimeException("Distance must be non-negative");
        }
        double angle;
        if(this.x < 0 || this.y < 0) {
            angle = Math.toRadians(Angle.normalize(bearing.reciprocate().getValue()));
        }
        else {
            angle = Math.toRadians(bearing.getValue()); // should this at least be normalized?
        }
        double targetX = this.x + (Math.cos(angle) * distance);
        double targetY = this.y + (Math.sin(angle) * distance);
        return new CoordinatesDelta(targetX, targetY);
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }

    public CoordinatesDelta subtract(CoordinatesDelta coordinates) {
        // Subtracts delta coordinates from this one and returns a new one with the difference.
        if(coordinates == null) {
            throw new RuntimeException("Null coordinates passed to CoordinatesDelta.subtract");
        }
        double newX = this.x - coordinates.x;
        double newY = this.y - coordinates.y;
        return new CoordinatesDelta(newX, newY);
    }

    public String toString() { return "X:" + this.x + ",Y:" + this.y; }
}
