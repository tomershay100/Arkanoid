//323082701
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * WideEasy class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lst.add(Velocity.fromAngleAndSpeed(-13.5 * (i + 1), 5));
            lst.add(Velocity.fromAngleAndSpeed(13.5 * (i + 1), 5));
        }
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 2;
    }

    @Override
    public int paddleWidth() {
        return 650;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sun();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        int blockWidth = 50;
        int blockHeight = 35;

        for (int j = 0; j < numberOfBlocksToRemove(); j++) {
            lst.add(new Block(new Rectangle(new Point(800 - 17
                    - (numberOfBlocksToRemove() - j) * (blockWidth + 1),
                    250), blockWidth, blockHeight)));
            lst.get(j).setColor(getColor(j));
        }

        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
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
            case 1:
                return Color.RED;
            case 2:
            case 3:
                return Color.ORANGE;
            case 4:
            case 5:
                return Color.YELLOW;
            case 6:
            case 7:
            case 8:
                return Color.GREEN;
            case 9:
            case 10:
                return Color.BLUE;
            case 11:
            case 12:
                return Color.PINK;
            case 13:
            case 14:
                return Color.CYAN;
            default:
                return Color.BLACK;
        }
    }
}
