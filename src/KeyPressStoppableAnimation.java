//323082701
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * KeyPressStoppableAnimation class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     * @param sensor KeyboardSensor
     * @param key the key.
     * @param animation the Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.key = key;
        this.animation = animation;
        this.sensor = sensor;
        this.stop = false;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(this.key) && !isAlreadyPressed) {
            this.stop = true;
        } else if (!this.sensor.isPressed(this.key)) {
            isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
    // ...
    // think about the implementations of doOneFrame and shouldStop.
}