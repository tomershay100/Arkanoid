//323082701
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
/**
 * BeforeTheBoss class - has gui, score, boolean stop and keyboard.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class BeforeTheBoss implements Animation {
    private final KeyboardSensor keyboard;
    private final int score;
    private final GUI gui;
    private boolean stop;

    /**
     * Constructor.
     * @param k the keyboard.
     * @param score the score.
     * @param gui the gui.
     */
    public BeforeTheBoss(KeyboardSensor k, int score, GUI gui) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.gui = gui;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        KeyPressStoppableAnimation keyPressStoppableAnimation;
        keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboard,
                "t", new ExtraLivesAnimation(score));
        AnimationRunner runner = new AnimationRunner(this.gui, 60);
        runner.run(keyPressStoppableAnimation);

        this.stop = true;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
