//323082701
import java.util.List;
/**
 * LevelInformation interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public interface LevelInformation {
    /**
     * number of balls in the game.
     * @return number of balls in the game.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * @return list of velocity.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle speed.
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * return the paddle Width.
     * @return the paddle Width.
     */
    int paddleWidth();

    /**
     * return the level Name.
     * @return the level Name.
     */
    String levelName();
    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return list of the blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed.
     * @return Number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();

}
