//323082701

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The background rectangle of the game.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class Background implements Sprite {
    private final Rectangle rectangle;
    private final Color color;

    /**
     * Constructor.
     *
     * @param rectangle the rectangle.
     * @param color     the color of the background.
     */
    public Background(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add the background to the Game.Game.
     *
     * @param g The Game.Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
