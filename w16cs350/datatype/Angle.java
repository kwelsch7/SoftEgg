/* Konnor Welsch - CS 350 */
package w16cs350.datatype;

public class Angle implements Comparable<Angle> {
    public static final Angle ANGLE_000 = new Angle(0.0);
    public static final Angle ANGLE_045 = new Angle(45.0);
    public static final Angle ANGLE_090 = new Angle(90.0);
    public static final Angle ANGLE_135 = new Angle(135.0);
    public static final Angle ANGLE_180 = new Angle(180.0);
    public static final Angle ANGLE_225 = new Angle(225.0);
    public static final Angle ANGLE_270 = new Angle(270.0);
    public static final Angle ANGLE_315 = new Angle(315.0);

    private double angle;

    public Angle(double angle) {
        if (angle < 0.0 || angle >= 360.0) {
            throw new RuntimeException("Given angle not on the [0, 360) scale");
        }
        this.angle = angle;
    }

    public Angle add(Angle angle) {
        // Adds an angle to this one and returns a new one with the normalized sum.
        if(angle == null) {
            throw new RuntimeException("Null angle passed to Angle.add");
        }
        double newAngle = normalize(this.angle + angle.angle);
        return new Angle(newAngle);
    }

    public int compareTo(Angle angle) {
        if(angle == null) {
            throw new RuntimeException("Null angle passed to Angle.compareTo");
        }
        return (int)(this.angle - angle.angle);
    }

    public double getValue() { return angle; }

    public static double normalize(double angle) {
        // Normalizes an angle to the interval [0,360).
        double normal = angle;
        while(normal < 0.0) normal += 360.0;
        while(normal >= 360.0) normal -= 360.0;
        return normal;
    }

    public Angle reciprocate() {
        // Returns a new angle as the reciprocal of this one.
        double reciprocal = normalize(this.angle + 180.0);
        return new Angle(reciprocal);
    }

    public Angle subtract(Angle angle) {
        // Subtracts an angle from this one and returns a new one with the normalized difference.
        if(angle == null) {
            throw new RuntimeException("Null angle passed to Angle.subtract");
        }
        double newAngle = normalize(this.angle - angle.angle);
        return new Angle(newAngle);
    }

    public String toString() { return "" + this.angle; }
}
