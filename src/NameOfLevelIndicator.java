//323082701
import biuoop.DrawSurface;
import extra.Draw;

import java.awt.Color;
/**
 * NameOfLevelIndicator class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class NameOfLevelIndicator implements Sprite {
    private final String nameOfLevel;

    /**
     * Constructor.
     * @param nameOfLevel the name of the level.
     */
    public NameOfLevelIndicator(String nameOfLevel) {
        this.nameOfLevel = nameOfLevel;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int fontSize = 15;
        String text = "Level Name: " + nameOfLevel;

        Draw.drawText(d, d.getWidth() / 2 - fontSize - 300, 22, text, fontSize, Color.GRAY.brighter());
    }

    @Override
    public void timePassed() {

    }
}
