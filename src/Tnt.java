//323082701
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Tnt class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class Tnt implements Sprite {
    private int sizeOfPixel = 20;
    /**
     * Constructor.
     * @param sizeOfPixel size of each pixel.
     */
    public Tnt(int sizeOfPixel) {
        this.sizeOfPixel = sizeOfPixel;
    }

    /**
     * Constructor.
     */
    public Tnt() {
    }
    /**
     * draw big pixel on the drawSurface.
     * @param d the DrawSurface.
     * @param color the color of the pixel.
     * @param x the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x, int y) {
        d.setColor(color);
        d.fillRectangle(x, y, sizeOfPixel, sizeOfPixel);
    }
    /**
     * Returns list of color in line according to the line number.
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList(int i) {

        Color red1 = new Color(220, 67, 26);
        Color red2 = new Color(201, 61, 26);
        Color red3 = new Color(186, 57, 18);
        Color red4 = new Color(154, 53, 23);
        Color red5 = new Color(195, 61, 26);
        Color red6 = new Color(169, 52, 19);
        Color red7 = new Color(146, 48, 23);
        Color red8 = new Color(206, 207, 202);
        Color red9 = new Color(206, 206, 206);
        Color red10 = new Color(223, 217, 219);
        Color red11 = new Color(176, 176, 176);
        Color red12 = new Color(182, 57, 25);
        Color red15 = new Color(119, 37, 13);
        Color red18 = new Color(197, 61, 23);
        Color red19 = new Color(176, 55, 24);
        Color red20 = new Color(164, 53, 23);

        if (i == 1) {
            return getColors(red1, red2, red3, red4);
        }

        if (i >= 2 && i <= 5) {
            return getColors(red1, red5, red6, red7);
        }

        if (i == 6) {
            List<Color> line1 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                line1.add(red8);
            }
            line1.add(red9);
            for (int j = 0; j < 4; j++) {
                line1.add(red10);
            }
            line1.add(red9);
            for (int j = 0; j < 2; j++) {
                line1.add(red10);
            }
            return getColors(red8, red9, red10, line1);
        }
        if (i == 7) {
            List<Color> line1 = new ArrayList<>();
            line1.add(red9);
            line1.add(red8);
            for (int j = 0; j < 3; j++) {
                line1.add(Color.BLACK);
            }
            line1.add(red9);
            line1.add(Color.BLACK);
            line1.add(red9);
            line1.add(red10);
            line1.add(Color.BLACK);
            line1.add(red9);
            for (int j = 0; j < 3; j++) {
                line1.add(Color.BLACK);
            }
            line1.add(red10);
            line1.add(red8);
            return line1;
        }
        if (i == 8) {
            List<Color> line1 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                line1.add(red9);
            }
            line1.add(Color.BLACK);
            for (int j = 0; j < 2; j++) {
                line1.add(red9);
            }
            for (int j = 0; j < 2; j++) {
                line1.add(Color.BLACK);
            }
            line1.add(red9);
            line1.add(Color.BLACK);
            return getColors(red9, line1);
        }
        if (i == 9) {
            List<Color> line1 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                line1.add(red9);
            }
            line1.add(Color.BLACK);
            for (int j = 0; j < 2; j++) {
                line1.add(red9);
            }
            line1.add(Color.BLACK);
            line1.add(red9);
            for (int j = 0; j < 2; j++) {
                line1.add(Color.BLACK);
            }
            return getColors(red9, line1);
        }
        if (i == 10) {
            List<Color> line1 = new ArrayList<>();
            line1.add(red9);
            for (int j = 0; j < 2; j++) {
                line1.add(red11);
            }
            line1.add(Color.BLACK);
            line1.add(red9);
            line1.add(red11);
            line1.add(Color.BLACK);
            for (int j = 0; j < 2; j++) {
                line1.add(red9);
            }
            line1.add(Color.BLACK);
            for (int j = 0; j < 2; j++) {
                line1.add(red9);
            }
            line1.add(Color.BLACK);
            for (int j = 0; j < 2; j++) {
                line1.add(red11);
            }
            line1.add(red9);
            return line1;
        }
        if (i == 11) {
            List<Color> line1 = new ArrayList<>();
            GameOverAnimation.getColors1(red11, red8, red11, red11, line1);
            for (int j = 0; j < 3; j++) {
                line1.add(red11);
            }
            return line1;
        }
        if (i == 12) {
            return getColors(red12, red6, red7, red15);
        }
        if (i >= 13 && i <= 15) {
            return getColors(red1, red5, red6, red7);
        }
        return getColors(red18, red19, red20, red7);
    }
    /**
     * returns colors list.
     * @param red9 color.
     * @param line1 the list.
     * @return colors list.
     */
    private List<Color> getColors(Color red9, List<Color> line1) {
        for (int j = 0; j < 2; j++) {
            line1.add(red9);
        }
        line1.add(Color.BLACK);
        for (int j = 0; j < 3; j++) {
            line1.add(red9);
        }
        return line1;
    }

    /**
     * returns colors list.
     * @param red8 color.
     * @param red9 color.
     * @param red10 color.
     * @param line1 color.
     * @return colors list.
     */
    private List<Color> getColors(Color red8, Color red9, Color red10, List<Color> line1) {
        for (int j = 0; j < 2; j++) {
            line1.add(red9);
        }
        for (int j = 0; j < 2; j++) {
            line1.add(red10);
        }
        line1.add(red8);
        return line1;
    }
    /**
     * returns colors list.
     * @param red1 color.
     * @param red2 color.
     * @param red3 color.
     * @param red4 color.
     * @return colors list.
     */
    private List<Color> getColors(Color red1, Color red2, Color red3, Color red4) {
        List<Color> line1 = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            line1.add(red1);
            line1.add(red2);
            line1.add(red3);
            line1.add(red4);
        }
        return line1;
    }
    /**
     * draw one TNT on the drawSurface.
     * @param d the drawSurface
     * @param x the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneTNT(DrawSurface d, int x, int y) {
        for (int i = 0; i < 16; i++) {
            List<Color> line1 = getLinesColorList(i + 1);
            for (int j = 0; j < line1.size(); j++) {
                Color color = line1.get(j);
                drawBigPixel(d, color, x + j * sizeOfPixel, y + sizeOfPixel * i);
            }
            line1.clear();
        }
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, sizeOfPixel * 16, sizeOfPixel * 16);
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                drawOneTNT(d, i * sizeOfPixel * 16, j * sizeOfPixel * 16);
            }
        }
    }

    @Override
    public void timePassed() {

    }
}
