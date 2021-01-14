//323082701
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Green3 class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(Velocity.fromAngleAndSpeed(45, 7));
        lst.add(Velocity.fromAngleAndSpeed(-45, 7));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new CreeperTntSprite();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        int amountOfLines = 6;
        int amountInLine = 12;
        int blockHeight = 30;
        int blockWidth = 52;
        int blockYSpace = 0;
        int blockXSpace = 0;
        //List<Block> lineOfBlocks = new ArrayList<>();
        for (int i = 0; i < amountOfLines; i++) {
            //lineOfBlocks.clear();
            for (int j = 0; j < amountInLine; j++) {
                Block block = new Block(new Rectangle(new Point(800 - 17 - 2
                        - (amountInLine - j) * (blockWidth + blockXSpace),
                        100 + (blockHeight + blockYSpace) * i), blockWidth, blockHeight));
                block.setColor(getColor(i));
                //block.setHitCountLeft(2);
                lst.add(block);
            }
            amountInLine--;
            if (amountInLine == 6) {
                break;
            }
        }
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 57;
    }

    /**
     * Returns color by the given index.
     *
     * @param i The given index.
     * @return color by the given index.
     */
    public Color getColor(int i) {
        switch (i) {
            case 0:
                return Color.GRAY;
            case 1:
                return Color.RED.darker();
            case 2:
                return Color.YELLOW.darker();
            case 3:
                return Color.CYAN.darker().darker();
            case 4:
                return Color.PINK.darker();
            case 5:
                return Color.GREEN.darker();
            default:
                return Color.BLACK;
        }
    }
}
