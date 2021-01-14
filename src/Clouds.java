//323082701
import biuoop.DrawSurface;

import java.awt.Color;
/**
 * Clouds class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class Clouds implements Sprite {
    /**
     * draw One Cloud on given DrawSurface.
     * @param d the DrawSurface.
     * @param x the x axis.
     * @param y the y axis.
     */
    public void drawOneCloud(DrawSurface d, int x, int y) {
        d.setColor(Color.WHITE);
        d.fillRectangle(x, y, 100, 20);
        d.fillCircle(x, y, 20);
        d.fillCircle(x + 100, y, 20);
        d.fillCircle(x + 40, y - 20, 40);
        d.fillCircle(x + 80, y - 10, 25);
    }

    @Override
    public void drawOn(DrawSurface d) {
        new Background(new Rectangle(new Point(0, 0), 800, 600), Color.cyan).drawOn(d);
        new Sun().drawOn(d);
        drawOneCloud(d, 585, 100);
        drawOneCloud(d, 400, 400);
        drawOneCloud(d, 100, 100);
        drawOneCloud(d, 650, 350);
        drawOneCloud(d, 200, 490);
        drawOneCloud(d, 620, 500);
        int x = 50, y = 150;
        d.setColor(Color.WHITE.darker());
        d.drawText(x - 1, y + 150 + 1, "You didn't expect something to be written here, eh?", 30);
        d.setColor(Color.BLACK.darker());
        d.drawText(x, y + 150, "You didn't expect something to be written here, eh?", 30);
        d.setColor(Color.WHITE.darker());
        d.drawText(x - 1, y + 100 + 1, "Be careful! Do you see the black block in the left corner?, GOOD.", 20);
        d.setColor(Color.BLACK.darker());
        d.drawText(x, y + 100, "Be careful! Do you see the black block in the left corner?, GOOD.", 20);
        d.setColor(Color.WHITE.darker());
        d.drawText(x - 1, y + 50 + 1, "I don't recommend you hit it with your balls.", 30);
        d.setColor(Color.BLACK.darker());
        d.drawText(x, y + 50, "I don't recommend you hit it with your balls.", 30);
        d.setColor(Color.WHITE.darker());
        d.drawText(x - 1, y + 1, "However, I highly recommend hitting the white block in the right corner ;)",
                19);
        d.setColor(Color.BLACK.darker());
        d.drawText(x, y, "However, I highly recommend hitting the white block in the right corner ;)", 19);
        d.setColor(Color.WHITE.darker());

        d.drawText(x - 1, y + 430 + 1, "You have received a new message", 15);
        d.setColor(Color.BLACK.darker());
        d.drawText(x, y + 430, "You have received a new message", 15);
    }

    @Override
    public void timePassed() {

    }
}
