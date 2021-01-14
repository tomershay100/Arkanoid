//323082701
import biuoop.DrawSurface;
import extra.Draw;

import java.awt.Color;
/**
 * LivesIndicator class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class LivesIndicator implements Sprite {
    private final Counter lives;

    /**
     * Constructor.
     * @param lives the lives.
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int fontSize = 15;
        String text = "Lives: " + lives.getValue();

        Draw.drawText(d, d.getWidth() / 2 - fontSize + 300, 22, text, fontSize, Color.GRAY.brighter());
    }

    @Override
    public void timePassed() {

    }
}
