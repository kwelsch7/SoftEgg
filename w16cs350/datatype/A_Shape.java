package w16cs350.datatype;

/*
    Defines the shared elements of all geometric shapes that consist of a single path
    from a start position to an end position. Start and end positions are defined in
    terms of delta coordinates in meters from reference coordinates in the world.
 */

public abstract class A_Shape {
    protected CoordinatesWorld reference;
    protected CoordinatesDelta deltaStart;
    protected CoordinatesDelta deltaEnd;
    protected int index;

    public A_Shape(CoordinatesWorld reference,
                   CoordinatesDelta deltaStart,
                   CoordinatesDelta deltaEnd) {
        this.reference = reference;
        this.deltaStart = deltaStart;
        this.deltaEnd = deltaEnd;
    }

    public A_Shape(CoordinatesWorld reference,
                   CoordinatesDelta deltaStart,
                   CoordinatesDelta deltaEnd,
                   int index) {
        this.reference = reference;
        this.deltaStart = deltaStart;
        this.deltaEnd = deltaEnd;
        this.index = index;
    }

    public CoordinatesDelta getDeltaEnd() {
        // Gets the delta position of the end of the path.
        return deltaEnd;
    }

    public CoordinatesDelta getDeltaStart() {
        // Gets the delta position of the start of the path.
        return deltaStart;
    }

    public int getIndex() {
        // Gets the optional index.
        return index;
    }

    public abstract double getLength(); // Gets the path length.

    public CoordinatesWorld getReference() {
        // Gets the reference coordinates.
        return reference;
    }

    public CoordinatesWorld getWorldEnd() {
        // Gets the world coordinates corresponding to the delta coordinates for the end of the path.
        return null;
    }

    public CoordinatesWorld getWorldStart() {
        // Gets the world coordinates corresponding to the delta coordinates for the start of the path.
        return null;
    }

    public boolean hasIndex() {
        // gets whether there is an index.
        return false;
    }

    public abstract CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB); // Interpolates delta coordinates along the path.

    public abstract CoordinatesWorld interpolateWorld(double distance, boolean isFromAOrB); // Interpolates world coordinates along the path.

    public abstract boolean isOnPath(double distance); // Determines whether a point at a distance from either end of this shape within the limits.

    public void setIndex(int index) {
        // Sets the optional index.
        this.index = index;
    }
}
