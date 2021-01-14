//323082701
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import extra.Draw;

import java.awt.Color;
/**
 * PauseScreen class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class PauseScreen implements Animation {
    private final KeyboardSensor keyboard;
    private boolean stop;
    private SpriteCollection spriteCollection;
    /**
     * Constructor.
     * @param k the KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * sets the sprite collection.
     * @param spriteCollection1 the sprite collection.
     */
    public void setSpriteCollection(SpriteCollection spriteCollection1) {
        this.spriteCollection = spriteCollection1;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        try {
            spriteCollection.drawAllOn(d);
        } catch (Exception ignored) {
            System.out.print("");
        }
        Draw.drawText(d, 800 - 250, 600 - 80, "space to continue", 20, Color.GRAY);
        Draw.drawBlock(d, 325, 150, 50, 300, Color.PINK.darker());
        Draw.drawBlock(d, 425, 150, 50, 300, Color.PINK.darker());
    }
@Override
    public boolean shouldStop() {
        return this.stop;
    }
}