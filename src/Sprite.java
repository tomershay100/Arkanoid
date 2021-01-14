//323082701

import biuoop.DrawSurface;

/**
 * Interfaces.Sprite Interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public interface Sprite {

    /**
     * extra.Draw the sprite to the drawSurface screen.
     *
     * @param d the drawSurface.
     */
    void drawOn(DrawSurface d);


    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();
}