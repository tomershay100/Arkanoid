//323082701

/**
 * Geometries.Point Object - each Geometries.Point has x and y values.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-03-28
 */
public class Point {

    private final double x;
    private final double y;

    /**
     * Constructor.
     *
     * @param x value on X axis.
     * @param y value on Y axis.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The distance between two points.
     *
     * @param other check the distance from this point.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        if (other == null) {
            return -1;
        }
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * Check if two points has the same x ant y values.
     *
     * @param other check if this point equal to other point.
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (this.x == other.getX() && this.y == other.getY());
    }

    /**
     * return the x value of this point.
     *
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * return the y value of this point.
     *
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}
