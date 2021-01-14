//323082701

/**
 * HitListener interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit. The hitter parameter is the Ball.
     * Ball that's doing the hitting.
     *
     * @param beingHit the block.
     * @param hitter   the ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}