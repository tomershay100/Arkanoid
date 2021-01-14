//323082701

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner class - has gui, fps and sleeper.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;
    private final Sleeper sleeper;

    /**
     * Constructor.
     * @param gui the gui.
     * @param framesPerSecond the FPS.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }

    /**
     * Returns the GUI.
     * @return the GUI.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Run the animation until it should stop.
     * @param animation the animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}