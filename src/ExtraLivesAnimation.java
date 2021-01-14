//323082701
import biuoop.DrawSurface;

import java.awt.Color;
/**
 * ExtraLivesAnimation class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class ExtraLivesAnimation implements Animation {
    private final int score;
    private final boolean stop;

    /**
     * Constructor.
     * @param score the score.
     */
    public ExtraLivesAnimation(int score) {
        this.score = score;
        stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        TheBossSprite theBossSprite = new TheBossSprite();
        theBossSprite.drawOn(d);
        //d.setColor(Color.CYAN);
        //d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.ORANGE.darker());
        d.drawText(d.getWidth() / 2 - 350 - 1, d.getHeight() / 2 + 50 + 1,
                "Congratulations, you've reached the Final Four stage.", 25);
        d.drawText(d.getWidth() / 2 - 350 - 1, d.getHeight() / 2 + 100 + 1,
                "I'm Tomer Shay, the creator of the game, allow me to congratulate you and raise your lives.",
                17);
        d.drawText(d.getWidth() / 2 - 350 - 1, d.getHeight() / 2 + 150 + 1,
                "Please press \"T\" to get extra 2 lives and keep playing", 15);
        d.drawText(d.getWidth() / 2 - 350 - 1, d.getHeight() / 2 + 200 + 1,
                "Your Score: " + this.score, 13);
        d.setColor(Color.BLACK);
        d.drawText(d.getWidth() / 2 - 350, d.getHeight() / 2 + 50,
                "Congratulations, you've reached the Final Four stage.", 25);
        d.drawText(d.getWidth() / 2 - 350, d.getHeight() / 2 + 100,
                "I'm Tomer Shay, the creator of the game, allow me to congratulate you and raise your lives.",
                17);
        d.drawText(d.getWidth() / 2 - 350, d.getHeight() / 2 + 150,
                "Please press \"T\" to get extra 2 lives and keep playing", 15);
        d.drawText(d.getWidth() / 2 - 350, d.getHeight() / 2 + 200,
                "Your Score: " + this.score, 13);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
