//323082701

import java.util.ArrayList;
import java.util.List;

/**
 * Game.GameEnvironment Object - Game.GameEnvironment Game.Game has List of Collidables.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class GameEnvironment {
    private final List<Collidable> collidables;

    /**
     * Init the Game.GameEnvironment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c the given collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Returns the information about the closest collision that is going to occur between given line to collidables.
     *
     * @param trajectory the given line.
     * @return the the information about the closest collision that is going to occur, or null if there is no collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> intersectingCollisionInfo = new ArrayList<>();
        CollisionInfo minDistanceCollisionInfo;
        double minDistance;
        for (Collidable c : this.collidables) {
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (p != null) {
                intersectingCollisionInfo.add(new CollisionInfo(p, c));
            }
        }
        if (intersectingCollisionInfo.isEmpty()) {
            return null;
        }
        //init first
        minDistance = trajectory.start().distance(intersectingCollisionInfo.get(0).collisionPoint());
        minDistanceCollisionInfo = intersectingCollisionInfo.get(0);

        for (CollisionInfo cI : intersectingCollisionInfo) {
            if (trajectory.start().distance(cI.collisionPoint()) < minDistance) {
                minDistance = trajectory.start().distance(cI.collisionPoint());
                minDistanceCollisionInfo = cI;
            }
        }
        return minDistanceCollisionInfo;
    }

    /**
     * remove c from collidables.
     *
     * @param c the Collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        if (collidables.contains(c)) {
            collidables.remove(c);
        } else {
            System.out.println("Error! you try to remove Interfaces.Collidable that doesn't exist!");
        }
    }
}