//323082701

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Ball.Ball Object - each Ball.Ball has center Geometries.Point, radius, color, velocity and a game environment.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.2
 * @since 2020-04-24
 */
public class Ball implements Sprite {

    private final int r;
    private final Color color;
    private Point center;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     *
     * @param center the center of the ball.
     * @param r      the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        //this.hitListeners = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param x     the x value of the center of the ball.
     * @param y     the y value of the center of the ball.
     * @param r     the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        //this.hitListeners = new ArrayList<>();
    }

    /**
     * @return the x value of the center of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y value of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the velocity of the ball.
     *
     * @param dx the change of x value.
     * @param dy the change of y value.
     */
    public void setVelocity(double dx, double dy) {
        this.setVelocity(new Velocity(dx, dy));
    }

    /**
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Set the velocity of the ball.
     *
     * @param vel the velocity.
     */
    public void setVelocity(Velocity vel) {
        this.v = vel;
    }

    /**
     * By creating a line out of the center of the ball in the direction and size of the velocity vector and testing
     * whether this line cuts collidable found in the game environment: If the line cuts something, it is a sign that
     * the next movement has a collidable that blocks the ball from moving and therefore changes the direction of the
     * ball. If the line does not cut then the ball will continue in the same direction with the same speed.
     * The action itself reads a maximum of 4 times to check if a change in ball speed is possible, if it is not
     * possible again.
     */
    public void moveOneStep() {
        List<CollisionInfo> collisionInfoList = new ArrayList<>();
        List<Double> distanceList = new ArrayList<>();
        CollisionInfo minDistanceCollisionInfo;
        double minDistance;

        double distance = this.center.distance(this.getVelocity().applyToPoint(this.center));
        double xNewStart = this.center.getX() + this.r * this.getVelocity().getDx() / distance;
        double yNewStart = this.center.getY() + this.r * this.getVelocity().getDy() / distance;

        for (int j = 0; j < 5; j++) {
            /*
            Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
            CollisionInfo c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 == null) {
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
            this.setVelocity(c1.collisionObject().hit(c1.collisionPoint(), this.getVelocity()));
            */
            collisionInfoList.clear();
            distanceList.clear();

            Point start1 = new Point(xNewStart, yNewStart);
            //start1 = this.getVelocity().applyToPoint(start1);
            Point end1 = this.getVelocity().applyToPoint(start1);
            start1 = new Point(xNewStart, yNewStart);
            Line trajectory = new Line(start1, end1);
            CollisionInfo c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 != null) {
                collisionInfoList.add(c1);
                distanceList.add(c1.collisionPoint().distance(this.center));
            }

            Point start2 = new Point(this.center.getX() + Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() - Math.abs(start1.getX() - this.center.getX()));
            //start2 = this.getVelocity().applyToPoint(start2);
            Point end2 = this.getVelocity().applyToPoint(start2);
            start2 = new Point(this.center.getX() + Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() - Math.abs(start1.getX() - this.center.getX()));
            trajectory = new Line(start2, end2);
            c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 != null) {
                collisionInfoList.add(c1);
                distanceList.add(c1.collisionPoint().distance(this.center));
            }

            Point start3 = new Point(this.center.getX() - Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() + Math.abs(start1.getX() - this.center.getX()));
            //start3 = this.getVelocity().applyToPoint(start3);
            Point end3 = this.getVelocity().applyToPoint(start3);
            start3 = new Point(this.center.getX() - Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() + Math.abs(start1.getX() - this.center.getX()));
            trajectory = new Line(start3, end3);
            c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 != null) {
                collisionInfoList.add(c1);
                distanceList.add(c1.collisionPoint().distance(this.center));
            }

            Point start4 = new Point(this.center.getX() + Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() + Math.abs(start1.getX() - this.center.getX()));
            //start4 = this.getVelocity().applyToPoint(start4);
            Point end4 = this.getVelocity().applyToPoint(start4);
            start4 = new Point(this.center.getX() + Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() + Math.abs(start1.getX() - this.center.getX()));
            trajectory = new Line(start4, end4);
            c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 != null) {
                collisionInfoList.add(c1);
                distanceList.add(c1.collisionPoint().distance(this.center));
            }

            Point start5 = new Point(this.center.getX() - Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() - Math.abs(start1.getX() - this.center.getX()));
            //start5 = this.getVelocity().applyToPoint(start5);
            Point end5 = this.getVelocity().applyToPoint(start5);
            start5 = new Point(this.center.getX() - Math.abs(start1.getY() - this.center.getY()),
                    this.center.getY() - Math.abs(start1.getX() - this.center.getX()));
            trajectory = new Line(start5, end5);
            c1 = this.gameEnvironment.getClosestCollision(trajectory);
            if (c1 != null) {
                collisionInfoList.add(c1);
                distanceList.add(c1.collisionPoint().distance(this.center));
            }

            if (collisionInfoList.isEmpty()) {
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
            //init first
            minDistance = distanceList.get(0);
            minDistanceCollisionInfo = collisionInfoList.get(0);

            for (int i = 0; i < collisionInfoList.size(); i++) {
                CollisionInfo cI = collisionInfoList.get(i);
                if (distanceList.get(i) < minDistance) {
                    minDistance = distanceList.get(i);
                    minDistanceCollisionInfo = cI;
                }
            }

            this.setVelocity(minDistanceCollisionInfo.collisionObject().hit(this,
                    minDistanceCollisionInfo.collisionPoint(),
                    this.getVelocity()));
        }

        this.center = this.getVelocity().applyToPoint(this.center);
    }
        /*
        for (int j = 0; j < 5; j++) {
            Geometries.Line trajectory = new Geometries.Line(this.center,
                    this.getVelocity().applyToPoint(this.getVelocity().applyToPoint(this.center)));
            Ball.CollisionInfo c = this.gameEnvironment.getClosestCollision(trajectory);
            if (c == null) {
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
            this.setVelocity(c.collisionObject().hit(this, c.collisionPoint(), this.getVelocity()));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    *
/*
    /**
     * Set the point of the ball next point according to its velocity and position. the surface is according to the
     * given borders.
     *
     * @param x1 Component x of the beginning of the screen border.
     * @param y1 Component y of the beginning of the screen border.
     * @param x2 Component x of the end of the screen border.
     * @param y2 Component x of the end of the screen border.
     *
    public void moveOneStep(int x1, int y1, int x2, int y2) {
        Point nextPoint = this.getVelocity().applyToPoint(this.center);
        //If the next position of the ball is on one side or beyond, the velocity changes in such a way that the
        //difference on the x axis changes to -dx.
        if (nextPoint.getX() + this.r >= x2 || nextPoint.getX() - this.r <= x1) {
            this.setVelocity(-this.v.getDx(), this.v.getDy());
        }
        //If the next position of the ball is at the up or down boundary or beyond the velocity changes so that the
        //difference on the axis y changes to -dy.
        if (nextPoint.getY() + this.r >= y2 || nextPoint.getY() - this.r <= y1) {
            this.setVelocity(this.v.getDx(), -this.v.getDy());
        }
        nextPoint = this.getVelocity().applyToPoint(this.center);
        //In case the ball is large so that wherever it moves it is out of frame, then it will not move.
        if ((nextPoint.getX() + this.r > x2 || nextPoint.getX() - this.r < x1) || (nextPoint.getY() + this.r > y2
                || nextPoint.getY() - this.r < y1)) {
            return;
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }*/

    /**
     * extra.Draw the ball on the given DrawSurface.
     *
     * @param surface the DrawSurface that given.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        //dark
        surface.setColor(Color.darkGray.darker());
        surface.fillCircle(this.getX() - 1, this.getY() + 2, this.getSize());
        //color
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        //dot
        surface.setColor(Color.GRAY.darker().darker().darker());
        surface.fillCircle(this.getX(), this.getY(), 2);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Add the ball to the Game.Game.
     *
     * @param g The Game.Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * set the game environment.
     *
     * @param g the game environment.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }
/*
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        if (this.hitListeners.contains(hl)) {
            hitListeners.remove(hl);
        } else {
            System.out.println("Error! you try to remove Interfaces.HitListener that doesn't exist!");
        }
    }*/

    /**
     * remove the ball from the game.
     *
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}