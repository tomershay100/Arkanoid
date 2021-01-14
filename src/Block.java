//323082701

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * BlocksPackage.Block Object - each Ball.Ball has rectangle and color.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private final Rectangle rectangle;
    private final List<HitListener> hitListeners;
    private boolean isDeathBlock;
    private Color color;
    private boolean isDupBalls;
    private int hitCountLeft;
    private boolean isBorderBlock;

    /**
     * Constructor.
     *
     * @param rectangle The block's rectangle.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
        this.isDeathBlock = false;
        this.isDupBalls = false;
        this.hitCountLeft = 1;
        this.isBorderBlock = false;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);

        final double epsilon = Math.pow(10, -8);
        int count = 0;
        if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX() - this.rectangle.getWidth())
                < epsilon) {
            currentVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            count++;
        }
        if ((Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < epsilon
                || Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY() - this.rectangle.getHeight())
                < epsilon) || count == 0) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * Set the block's color.
     *
     * @param c The new color.
     */
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        //dark
        surface.setColor(Color.darkGray.darker());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY() + 5, (int) this.rectangle.getWidth() - 4,
                (int) this.rectangle.getHeight() - 5);
        //color
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 1,
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight() - 2);
        //dots
        surface.setColor(Color.GRAY.darker().darker().darker());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 5,
                (int) this.rectangle.getUpperLeft().getY() + 4, 3, 3);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 5,
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() - 8), 3, 3);
        surface.fillRectangle((int) (this.rectangle.getUpperLeft().getX() - 5 + this.rectangle.getWidth()),
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() - 8), 3, 3);
        surface.fillRectangle((int) (this.rectangle.getUpperLeft().getX() - 5 + this.rectangle.getWidth()),
                (int) this.rectangle.getUpperLeft().getY() + 4, 3, 3);
        //bright
        surface.setColor(Color.LIGHT_GRAY.brighter());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 4,
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth() - 3, 2);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + (int) this.rectangle.getWidth(),
                (int) this.rectangle.getUpperLeft().getY(), 1, (int) this.rectangle.getHeight() - 5);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add the block to the Game.Game.
     *
     * @param g The Game.Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Removes the block from the game.
     *
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * Notify all listeners about a hit event.
     *
     * @param hitter the ball that hit the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            //System.out.println("$");
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        //if (this.hitListeners.contains(hl)) {
            hitListeners.remove(hl);
        //} else {
        //    System.out.println("Error! you try to remove Interfaces.HitListener that doesn't exist!");
        //}
    }

    /**
     * Returns if the block is death block.
     *
     * @return if the block is death block.
     */
    public boolean isDeathBlock() {
        return this.isDeathBlock;
    }

    /**
     * Set the isDeathBlock.
     *
     * @param isDeath the boolean we want to set to.
     */
    public void setDeathBlock(boolean isDeath) {
        this.isDeathBlock = isDeath;
    }

    /**
     * Returns if the block is dup block. (when ball hits dup block, another ball appears).
     *
     * @return if the block is dup block.
     */
    public boolean isDupBalls() {
        return this.isDupBalls;
    }

    /**
     * Set the isDupBalls.
     *
     * @param isDup the boolean we want to set to.
     */
    public void setDupBalls(boolean isDup) {
        this.isDupBalls = isDup;
    }

    /**
     * Decrease hit counter.
     */
    public void decreaseHitCount() {
        this.hitCountLeft--;
    }

    /**
     * Returns hit counter.
     *
     * @return hit counter.
     */
    public int getHitCountLeft() {
        return this.hitCountLeft;
    }

    /**
     * Set the hit count left of the ball.
     * @param hitCountLeft1 the hit count left.
     */
    public void setHitCountLeft(int hitCountLeft1) {
        this.hitCountLeft = hitCountLeft1;
    }

    /**
     * makes the color brighter.
     */
    public void brightColor() {
        this.color = this.color.brighter();
    }

    /**
     * Set the isBorderBlock.
     *
     * @param isBorder the boolean we want to set to.
     */
    public void setIsBorder(boolean isBorder) {
        this.isBorderBlock = isBorder;
    }

    /**
     * Returns if the block is border block.
     *
     * @return if the block is border block.
     */
    public boolean isBorderBlock() {
        return this.isBorderBlock;
    }
}