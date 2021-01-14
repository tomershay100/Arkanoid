//323082701

import biuoop.DrawSurface;
import extra.Draw;

import java.awt.Color;

/**
 * ScoreIndicator class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;

    /**
     * constructor.
     *
     * @param score the counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int fontSize = 15;
        String text = "score: " + this.score.getValue();
        //Easter egg
        if (this.score.getValue() == 404) {
            text = "Error " + this.score.getValue() + ": your score doesn't found";
        }
        Draw.drawText(d, d.getWidth() / 2 - fontSize, 22, text, fontSize, Color.GRAY.brighter());
    }

    @Override
    public void timePassed() {

    }
}
