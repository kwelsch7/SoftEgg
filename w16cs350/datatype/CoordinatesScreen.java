package w16cs350.datatype;

/*
    Defines coordinates in a standard graphics coordinate system with pixel units.
 */

public class CoordinatesScreen {
    private int x;
    private int y;
    private boolean isVisible;

    public CoordinatesScreen(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisible = true;
    }

    public CoordinatesScreen add(CoordinatesScreen coordinates) {
        // Adds screen coordinates to this one and returns a new one with the sum.
        return null;
    }

    public CoordinatesScreen getHalf() {
        // Returns the midpoint between (0,0) and these coordinates as new screen coordinates.
        return null;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public boolean isVisible() {
        // Gets whether the coordinates are visible.
        return this.isVisible;
    }

    public void isVisible(boolean isVisible) {
        // Sets whether the coordinates are visible.
        this.isVisible = isVisible;
    }

    public CoordinatesScreen subtract(CoordinatesScreen coordinates) {
        // Subtracts screen coordinates from this one and returns a new one with the difference.
        return null;
    }

    public String toString() { return "X:" + this.x + ",Y:" + this.y; }
}