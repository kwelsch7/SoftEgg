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
        index = -1;
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
        return this.deltaEnd;
    }

    public CoordinatesDelta getDeltaStart() {
        // Gets the delta position of the start of the path.
        return this.deltaStart;
    }

    public int getIndex() {
        // Gets the optional index.
        return this.index;
    }

    public abstract double getLength(); // Gets the path length.

    public CoordinatesWorld getReference() {
        // Gets the reference coordinates.
        return this.reference;
    }

    public CoordinatesWorld getWorldEnd() {
        // Gets the world coordinates corresponding to the delta coordinates for the end of the path.
        return reference.calculateTarget(this.deltaEnd);
    }

    public CoordinatesWorld getWorldStart() {
        // Gets the world coordinates corresponding to the delta coordinates for the start of the path.
        return reference.calculateTarget(this.deltaStart);
    }

    public boolean hasIndex() {
        // gets whether there is an index.
        return this.index != -1;
    }

    public abstract CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB); // Interpolates delta coordinates along the path.

    public CoordinatesWorld interpolateWorld(double distance, boolean isFromAOrB) {
        // Interpolates world coordinates along the path.
        if (!isOnPath(distance)) {
            throw new RuntimeException();
        }
        CoordinatesDelta delta = interpolateDelta(distance, isFromAOrB);
        return reference.calculateTarget(delta);
    }

    public abstract boolean isOnPath(double distance); // Determines whether a point at a distance from either end of this shape within the limits.

    public void setIndex(int index) {
        // Sets the optional index.
        this.index = index;
    }
}
