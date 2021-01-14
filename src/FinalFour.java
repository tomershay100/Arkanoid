//323082701
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * FinalFour class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(Velocity.fromAngleAndSpeed(45, 8));
        lst.add(Velocity.fromAngleAndSpeed(-45, 8));
        lst.add(Velocity.fromAngleAndSpeed(0, 8));
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new MarioBackground();
        //return new Background(new Rectangle(new Point(0,0),800,600), Color.cyan);
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        int amountOfLines = 7;
        int amountInLine = 17;
        int blockHeight = 30;
        int blockWidth = 45;
        int blockYSpace = 0;
        int blockXSpace = 0;
        for (int i = 0; i < amountOfLines; i++) {
            for (int j = 0; j < amountInLine; j++) {
                Block block = new Block(new Rectangle(new Point(800 - 17 - 2
                        - (amountInLine - j) * (blockWidth + blockXSpace),
                        100 + (blockHeight + blockYSpace) * i), blockWidth, blockHeight));
                if (i % 2 == 0 ^ j % 2 == 0) {
                    block.setColor(Color.darkGray.darker());
                    block.setHitCountLeft(2);
                } else {
                    block.setColor(getColor(i));
                    block.setHitCountLeft(1);
                }
                lst.add(block);
            }
        }
        Block addBalls = new Block(new Rectangle(new Point(
                800 - 17 - 2 * 2 - 40,
                2 * 2 + 2 * 17), 40, 40));
        addBalls.setDupBalls(true);
        //addBalls.addHitListener(this.blockR);
        //addBalls.addHitListener(this.ballR);
        addBalls.setColor(Color.WHITE);
        lst.add(addBalls);
        //addBalls.addToGame(this);
        //deathBlock.addToGame(this);
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 119;
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
                return Color.MAGENTA.darker();
        }
    }
}
