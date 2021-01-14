//323082701


/**
 * Collidable interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  The hit point.
     * @param currentVelocity The hit Ball.Velocity.
     * @param hitter          the ball that hit.
     * @return is the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

