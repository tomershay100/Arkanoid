//323082701

import biuoop.DrawSurface;

/**
 * Clouds class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class MarioBackground implements Sprite {
    private final FlappyBird bird;
    private final Mario mario;
    /**
     * Constructor.
     */
    public MarioBackground() {
        bird = new FlappyBird();
        mario = new Mario();
    }

    @Override
    public void drawOn(DrawSurface d) {
        new Clouds().drawOn(d);
        mario.drawOn(d);
        bird.drawOn(d);
    }

    @Override
    public void timePassed() {
        bird.timePassed();
        mario.timePassed();
    }
}
