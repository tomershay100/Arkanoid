//323082701

/**
 * Ball.CollisionInfo Object - each Ball.CollisionInfo has Interfaces.Collidable and Geometries.Point.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class CollisionInfo {
    private final Point point;
    private final Collidable collidable;

    /**
     * Constructor.
     *
     * @param point      the Ball.CollisionInfo point, at which the collision occurs.
     * @param collidable the collidable object involved in the collision.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.collidable = collidable;
        this.point = point;
    }

    /**
     * Returns the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * Returns the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}