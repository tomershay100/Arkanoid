//323082701

import java.util.ArrayList;
import java.util.List;

/**
 * Geometries.Rectangle Object - each Geometries.Rectangle has a width, a height and a Geometries.Point.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class Rectangle {

    private final double width;
    private final double height;
    private Point upperLeft;


    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft The upper Left point.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Set the upper Left point to the given point.
     *
     * @param point The given point.
     */
    public void setPoint(Point point) {
        this.upperLeft = point;
    }

    /**
     * Return a  List of intersection points with the given line.
     *
     * @param line the given line.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> l = new ArrayList<>();
        //each rectangle has 4 points.
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point lowerRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        //each rectangle has 4 lines.
        Line a = new Line(this.upperLeft, upperRight);
        Line b = new Line(upperRight, lowerRight);
        Line c = new Line(lowerRight, lowerLeft);
        Line d = new Line(lowerLeft, this.upperLeft);
        if (line.isIntersecting(a)) {
            l.add(line.intersectionWith(a));
        }
        if (line.isIntersecting(b)) {
            l.add(line.intersectionWith(b));
        }
        if (line.isIntersecting(c)) {
            l.add(line.intersectionWith(c));
        }
        if (line.isIntersecting(d)) {
            l.add(line.intersectionWith(d));
        }
        return l;
    }


    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}