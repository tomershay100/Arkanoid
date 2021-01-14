//323082701

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Creeper class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class Mario implements Sprite {
    private final int sizeOfPixel = 5;
    private int y;
    private int needsToJump;
    private int velocity;

    /**
     * Constructor.
     */
    public Mario() {
        this.y = 2;
        needsToJump = 0;
        velocity = 10;
    }

    /**
     * draw big pixel on the drawSurface.
     *
     * @param d     the DrawSurface.
     * @param color the color of the pixel.
     * @param x     the the x of the upper left point.
     * @param y1     the the y of the upper left point.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x, int y1) {
        d.setColor(color);
        d.fillRectangle(x, y1, sizeOfPixel, sizeOfPixel);
    }

    /**
     * return color according to number.
     *
     * @param i the number.
     * @return color according to number.
     */
    public Color getColor(int i) {
        switch (i) {
            case 1:
                return new Color(255, 0, 0);
            case 2:
                return new Color(151, 72, 7);
            case 3:
                return new Color(250, 192, 144);
            case 4:
                return new Color(0, 0, 0);
            case 5:
                return new Color(0, 112, 192);
            case 6:
                return new Color(255, 255, 0);
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList1(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 1:
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 2:
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 10; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 1; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 3:
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(4));
                line1.add(getColor(3));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 4:
                line1.add(getColor(0));
                line1.add(getColor(2));
                line1.add(getColor(3));
                line1.add(getColor(2));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(4));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(0));
                return line1;
            case 5:
                line1.add(getColor(0));
                line1.add(getColor(2));
                line1.add(getColor(3));
                line1.add(getColor(2));
                line1.add(getColor(2));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(4));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                return line1;
            case 6:
                line1.add(getColor(0));
                line1.add(getColor(2));
                line1.add(getColor(2));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(3));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(0));
                return line1;
            case 7:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(0));
                for (int j = 0; j < 8; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(0));
                line1.add(getColor(0));
                return line1;
            case 8:
                line1.add(getColor(0));
                line1.add(getColor(0));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(5));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList2(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 9:
                line1.add(getColor(0));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(5));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(5));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 10:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(5));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 11:
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                line1.add(getColor(5));
                line1.add(getColor(6));
                line1.add(getColor(5));
                line1.add(getColor(5));
                line1.add(getColor(6));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(0));
                return line1;
            case 12:
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(5));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(0));
                return line1;
            case 13:
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                for (int j = 0; j < 8; j++) {
                    line1.add(getColor(5));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(0));
                return line1;
            case 14:
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(5));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(5));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 15:
                line1.add(getColor(0));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 16:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(0));
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList(int i) {
        if (i < 9) {
            return getLinesColorList1(i);
        }
        return getLinesColorList2(i);
    }

    /**
     * draw one mario on the drawSurface.
     *
     * @param d the drawSurface
     * @param x the the x of the upper left point.
     * @param y1 the the y of the upper left point.
     */
    public void drawOneMario(DrawSurface d, int x, int y1) {
        for (int i = 0; i < 16; i++) {
            List<Color> line1 = getLinesColorList(i + 1);
            for (int j = 0; j < line1.size(); j++) {
                if (line1.get(j) != null) {
                    Color color = line1.get(j);
                    drawBigPixel(d, color, x + j * sizeOfPixel, y1 + sizeOfPixel * i);
                }
            }
            line1.clear();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawOneMario(d, 100, 490 - this.y);
    }

    @Override
    public void timePassed() {
        if (this.needsToJump % 3 == 0) {
            y += velocity;
            velocity -= 1.2;
            if (y <= 5) {
                velocity = 20;
            }
        }
        needsToJump++;
    }
}
