//323082701

/**
 * Ball.Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.3
 * @since 2020-04-24
 */
public class Velocity {
    private final double dx;
    private final double dy;


    /**
     * Constructor.
     *
     * @param dx the change of x value.
     * @param dy the change of y value.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Converts velocity from SPEED and angle to difference between X and Y.
     *
     * @param angle the angle of the velocity.
     * @param speed the size of velocity.
     * @return the velocity that made from dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * @return the difference in x values.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the difference in y values.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p The starting point.
     * @return The destination point.
     */
    public Point applyToPoint(Point p) {
        if (p == null) {
            return null;
        }
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}