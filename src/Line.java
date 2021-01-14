//323082701

import java.util.List;

/**
 * Geometries.Line Object - each Geometries.Line has a start point and an end point..
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.1
 * @since 2020-04-24
 */
public class Line {

    private final Point start;
    private final Point end;

    /**
     * Constructor.
     *
     * @param start the start Geometries.Point.
     * @param end   the end Geometries.Point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor.
     *
     * @param x1 x value of start point.
     * @param y1 y value of start point.
     * @param x2 x value of end point.
     * @param y2 y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Calculate the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Calculate the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if 2 lines are Intersecting.
     *
     * @param other check if this line and other line are intersecting.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return this.isIntersecting1(other) || other.isIntersecting1(this);
    }

    /**
     * check this line is intersecting with other.
     *
     * @param other check if this line and other line are intersecting.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting1(Line other) {
        if (other == null || other.end == null || other.start == null || this.start == null || this.end == null) {
            return false;
        }
        double epsilon = Math.pow(10, -8);
        double m1;
        double m2;
        double n1;
        double n2;
        double x;
        double y;
        //In case their gradients exist
        if (Math.abs(this.start.getX() - this.end.getX()) > epsilon
                && Math.abs(other.start.getX() - other.end.getX()) > epsilon) {
            m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
            n1 = this.start.getY() - m1 * this.start.getX();
            n2 = other.start.getY() - m2 * other.start.getX();
            if (Math.abs(m1 - m2) <= epsilon) {
                //in case the lines are parallel but still have only one common point.
                //when their common point is the start or the end point.
                return ((this.end.equals(other.start) && ((this.start.getX() <= this.end.getX()
                        && other.start.getX() <= other.end.getX()) || (this.start.getX() >= this.end.getX()
                        && other.start.getX() >= other.end.getX()))) || (this.end.equals(other.end)
                        && ((this.start.getX() <= this.end.getX() && other.end.getX() <= other.start.getX())
                        || (this.start.getX() >= this.end.getX() && other.end.getX() >= other.start.getX())))
                        || (this.start.equals(other.start) && ((this.start.getX() <= this.end.getX()
                        && other.end.getX() <= other.start.getX()) || (this.start.getX() >= this.end.getX()
                        && other.end.getX() >= other.start.getX()))) || (this.start.equals(other.end)
                        && ((this.start.getX() <= this.end.getX() && other.start.getX() <= other.end.getX())
                        || (this.start.getX() >= this.end.getX() && other.start.getX() >= other.end.getX()))));
            } else {
                //in case the lines are not parallel, check if their common point is in the range of the lines.
                x = (n1 - n2) / (m2 - m1);
                y = m1 * x + n1;
                return (!(x > Math.max(this.start.getX(), this.end.getX()))
                        && !(x < Math.min(this.start.getX(), this.end.getX()))
                        && !(x > Math.max(other.start.getX(), other.end.getX()))
                        && !(x < Math.min(other.start.getX(), other.end.getX()))
                        && !(y > Math.max(this.start.getY(), this.end.getY()))
                        && !(y < Math.min(this.start.getY(), this.end.getY()))
                        && !(y > Math.max(other.start.getY(), other.end.getY()))
                        && !(y < Math.min(other.start.getY(), other.end.getY())));
            }
        } else if (Math.abs(this.start.getX() - this.end.getX()) < epsilon
                && Math.abs(other.start.getX() - other.end.getX()) < epsilon) {
            //In case both lines is parallel to the Y axis.
            //in case the lines are parallel but still have only one common point.
            return ((this.end.equals(other.start) && ((this.start.getY() <= this.end.getY()
                    && other.start.getY() <= other.end.getY()) || (this.start.getY() >= this.end.getY()
                    && other.start.getY() >= other.end.getY()))) || (this.end.equals(other.end)
                    && ((this.start.getY() <= this.end.getY() && other.end.getY() <= other.start.getY())
                    || (this.start.getY() >= this.end.getY() && other.end.getY() >= other.start.getY())))
                    || (this.start.equals(other.start) && ((this.start.getY() <= this.end.getY()
                    && other.end.getY() <= other.start.getY()) || (this.start.getY() >= this.end.getY()
                    && other.end.getY() >= other.start.getY()))) || (this.start.equals(other.end)
                    && ((this.start.getY() <= this.end.getY() && other.start.getY() <= other.end.getY())
                    || (this.start.getY() >= this.end.getY() && other.start.getY() >= other.end.getY()))));
        } else if (Math.abs(other.start.getX() - other.end.getX()) < epsilon) {
            //In case only one line is parallel to the Y axis
            //check if their common point is in the range of the lines.
            m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            n1 = this.start.getY() - m1 * this.start.getX();
            x = other.start.getX();
            y = m1 * x + n1;
            return (!(x > Math.max(this.start.getX(), this.end.getX()))
                    && !(x < Math.min(this.start.getX(), this.end.getX()))
                    && !(y > Math.max(this.start.getY(), this.end.getY()))
                    && !(y < Math.min(this.start.getY(), this.end.getY()))
                    && !(y > Math.max(other.start.getY(), other.end.getY()))
                    && !(y < Math.min(other.start.getY(), other.end.getY())));
        } else {
            //In case the other line is parallel to the Y axis
            //check if their common point is in the range of the lines.
            m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
            n2 = other.start.getY() - m2 * other.start.getX();
            x = this.start.getX();
            y = m2 * x + n2;
            return (!(x > Math.max(other.start.getX(), other.end.getX()))
                    && !(x < Math.min(other.start.getX(), other.end.getX()))
                    && !(y > Math.max(this.start.getY(), this.end.getY()))
                    && !(y < Math.min(this.start.getY(), this.end.getY()))
                    && !(y > Math.max(other.start.getY(), other.end.getY()))
                    && !(y < Math.min(other.start.getY(), other.end.getY())));
        }
    }

    /**
     * Calculate the intersection point between to lines.
     *
     * @param other check if this line and other line are intersecting.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (other == null || other.end == null || other.start == null || this.start == null || this.end == null) {
            return null;
        }
        if (this.isIntersecting(other)) {
            //if the straight meet at the starting point of the first straight
            if (this.start.equals(other.start) || this.start.equals(other.end)) {
                return this.start;
                //If the straight meets at the end of the first straight
            } else if (this.end.equals(other.start) || this.end.equals(other.end)) {
                return this.end;
            } else {
                //In case this line is parallel to the Y axis
                if (this.start.getX() - this.end.getX() == 0) {
                    double m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
                    double n2 = other.start.getY() - m2 * other.start.getX();
                    double x = this.start.getX();
                    double y = m2 * x + n2;
                    return new Point(x, y);
                    //In case the other line is parallel to the Y axis
                } else if (other.start.getX() - other.end.getX() == 0) {
                    double m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
                    double n1 = this.start.getY() - m1 * this.start.getX();
                    double x = other.start.getX();
                    double y = m1 * x + n1;
                    return new Point(x, y);
                } else {
                    double m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
                    double m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
                    double n1 = this.start.getY() - m1 * this.start.getX();
                    double n2 = other.start.getY() - m2 * other.start.getX();
                    double x = (n1 - n2) / (m2 - m1);
                    double y = m1 * x + n1;
                    return new Point(x, y);
                }
            }
        } else {
            return null;
        }
    }

    /**
     * check if two lines are equals.
     *
     * @param other check if this line and other point are equals.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (other == null || other.end == null || other.start == null || this.start == null || this.end == null) {
            return false;
        }
        return (this.start.equals(other.start) && this.end.equals(other.end));
    }

    /**
     * Returns the closest intersection point to the start of the line.
     *
     * @param rect the given rectangle
     * @return the closest intersection point to the start of the line. If this line does not intersect with the
     * rectangle, return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        Point minDistancePoint;
        double minDistance;
        if (list.isEmpty()) {
            return null;
        }
        //init first
        minDistance = this.start.distance(list.get(0));
        minDistancePoint = list.get(0);
        for (Point p : list) {
            if (minDistance > this.start.distance(p)) {
                minDistance = this.start.distance(p);
                minDistancePoint = p;
            }
        }
        return minDistancePoint;
    }
}
