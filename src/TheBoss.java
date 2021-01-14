//323082701
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * TheBoss class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class TheBoss implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 20;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lst.add(new Velocity(0, -10));
        }
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "The Boss";
    }

    @Override
    public Sprite getBackground() {
        return new TheBossSprite();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            List<Color> tntBlocks = new Tnt().getLinesColorList(i + 1);
            for (int j = 0; j < tntBlocks.size(); j++) {
                Color color = tntBlocks.get(j);
                Block block = new Block(new Rectangle(new Point(430 + j * 20, 40 + 20 * i), 20, 20));
                block.setColor(color);
                lst.add(block);
            }
            tntBlocks.clear();
        }
        for (int i = 0; i < 10; i++) {
            List<Color> creeperBlocks = new Creeper().getLinesColorList(i + 1);
            for (int j = 0; j < creeperBlocks.size(); j++) {
                Color color = creeperBlocks.get(j);
                Block block = new Block(new Rectangle(new Point(40 + j * 25, 40 + 25 * i), 25, 25));
                block.setColor(color);
                block.setHitCountLeft(2);
                lst.add(block);
            }
            creeperBlocks.clear();
        }

        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 356;
    }

}
