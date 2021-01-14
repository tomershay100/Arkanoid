//323082701
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * TheBossSprite class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class TheBossSprite implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, 800, 600);
        new Creeper().drawOneCrepper(d, 40, 40);
        new Tnt().drawOneTNT(d, 430, 40);
    }

    @Override
    public void timePassed() {

    }
}
