//323082701
import biuoop.DrawSurface;

import java.awt.Color;
/**
 * TargetBoard class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class TargetBoard implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int gameWidth = 800;
        int gameHeight = 600;
        Point circlePoint = new Point(400, 200);

        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, gameWidth, gameHeight);
        d.setColor(Color.WHITE);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 200);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 180);
        d.setColor(Color.BLUE);
        d.fillCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 160);
        d.setColor(Color.RED);
        d.fillCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 120);
        d.setColor(Color.YELLOW);
        d.fillCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 80);
        d.setColor(Color.ORANGE);
        d.fillCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 20);
        d.setColor(Color.BLACK);
        d.fillCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 4);

        d.setColor(Color.BLACK);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 160);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 140);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 120);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 100);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 80);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 60);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 40);
        d.drawCircle((int) circlePoint.getX(), (int) circlePoint.getY(), 20);
    }

    @Override
    public void timePassed() {

    }
}
