//323082701
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
/**
 * EndScreen class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class EndScreen implements Animation {
    private final KeyboardSensor keyboard;
    private final boolean isLost;
    private final int score;
    private final GUI gui;
    private boolean stop;

    /**
     * Constructor.
     * @param k the keyboard.
     * @param isLost isLost.
     * @param score score.
     * @param gui GUI.
     */
    public EndScreen(KeyboardSensor k, boolean isLost, int score, GUI gui) {
        this.keyboard = k;
        this.stop = false;
        this.isLost = isLost;
        this.score = score;
        this.gui = gui;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        //AnimationRunner runner = new AnimationRunner(this.gui, 60);
        KeyPressStoppableAnimation keyPressStoppableAnimation;
        if (isLost) {
            keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboard,
                    "space", new GameOverAnimation(score));
        } else {
            keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboard,
                    "space", new YouWinAnimation(score));
        }
        AnimationRunner runner = new AnimationRunner(this.gui, 60);
        runner.run(keyPressStoppableAnimation);

        this.stop = true;
    }
@Override
    public boolean shouldStop() {
        return this.stop;
    }
}
