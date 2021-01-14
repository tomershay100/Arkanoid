//323082701
import biuoop.DrawSurface;
import biuoop.Sleeper;
import extra.Draw;

import java.awt.Color;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
/**
 * CountdownAnimation class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private final SpriteCollection gameScreen;
    private final int countFrom;
    private final Sleeper sleeper;
    private boolean shouldStop;
    private int currentNum;

    /**
     * Constructor.
     *
     * @param numOfSeconds the number of seconds.
     * @param countFrom    the number to count from.
     * @param gameScreen   the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
        this.countFrom = countFrom;
        sleeper = new Sleeper();
        shouldStop = false;
        currentNum = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        drawSec(d, currentNum);
        if (currentNum != countFrom) {
            sleeper.sleepFor((long) (1000 * numOfSeconds / countFrom));
        }
        if (currentNum == 0) {
            shouldStop = true;
        }
        currentNum--;
        //}
    }

    @Override
    public boolean shouldStop() {
        return shouldStop;
    }

    /**
     * draw sec.
     *
     * @param d   the drawSurface.
     * @param num the number.
     */
    public void drawSec(DrawSurface d, int num) {
        Draw.drawTextWithOutBorder(d, 350, 350, "" + num, 200, Color.GRAY.brighter());
    }
}