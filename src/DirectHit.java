//323082701
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * DirectHit class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(new Velocity(0, -5));
        //lst.add(new Velocity(-5, -5));
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "DirectHit";
    }

    @Override
    public Sprite getBackground() {
        return new TargetBoard();
    }

    @Override
    public List<Block> blocks() {
        int blockWidth = 50;
        int blockHeight = 20;
        Block block = new Block(new Rectangle(new Point(400 - (double) blockWidth / 2,
                200 - (double) blockHeight / 2), blockWidth, blockHeight));
        block.setColor(Color.GREEN);

        List<Block> lst = new ArrayList<>();
        lst.add(block);
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
