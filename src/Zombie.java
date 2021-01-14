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
public class Zombie implements Sprite {
    private final int sizeOfPixel = 25;

    /**
     * draw big pixel on the drawSurface.
     *
     * @param d     the DrawSurface.
     * @param color the color of the pixel.
     * @param x     the the x of the upper left point.
     * @param y     the the y of the upper left point.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x, int y) {
        d.setColor(color);
        d.fillRectangle(x, y, sizeOfPixel, sizeOfPixel);
    }
    /**
     * return color according to number.
     * @param i the number.
     * @return  color according to number.
     */
    public Color getColor(int i) {
        switch (i) {
            case 1:
            case 3:
                return Color.decode("#467536");
            case 2:
            case 11:
            case 7:
            case 9:
            case 10:
            case 17:
                return Color.decode("#436d35");
            case 4:
            case 16:
                return Color.decode("#3c6730");
            case 5:
                return Color.decode("#385e2a");
            case 6:
                return Color.decode("#3b622f");
            case 8:
                return Color.decode("#436934");
            case 12:
                return Color.decode("#4e7d3d");
            case 13:
            case 14:
                return Color.decode("#5b9142");
            case 15:
                return Color.decode("#466d36");
            case 18:
            case 19:
                return Color.decode("#6d955b");
            case 20:
                return Color.decode("#799c65");
            case 21:
                return Color.decode("#71955b");
            case 22:
                return Color.decode("#6f955c");
            case 23:
                return Color.decode("#5e8747");
            case 24:
                return Color.decode("#517b3c");
            case 25:
                return Color.decode("#638551");
            case 26:
                return Color.decode("#6a8d56");
            case 27:
                return Color.decode("#638551");
            case 28:
                return Color.decode("#698756");
            case 29:
                return Color.decode("#5a7b48");
            case 30:
                return Color.decode("#6f955c");
            case 31:
                return Color.decode("#517b3c");
            case 32:
                return Color.decode("#517b3c");
            case 33:
                return Color.decode("#6a8d56");
            case 34:
                return Color.decode("#1a1a1a");
            case 35:
                return Color.decode("#1a1a1a");
            case 36:
                return Color.decode("#6b8d50");
            case 37:
                return Color.decode("#70945a");
            case 38:
                return Color.decode("#1a1a1a");
            case 39:
                return Color.decode("#1a1a1a");
            case 40:
                return Color.decode("#638551");
            case 41:
                return Color.decode("#4e7b36");
            case 42:
                return Color.decode("#668d4e");
            case 43:
                return Color.decode("#73905a");
            case 44:
                return Color.decode("#385226");
            case 45:
                return Color.decode("#385226");
            case 46:
                return Color.decode("#6b9555");
            case 47:
                return Color.decode("#4d7f37");
            case 48:
                return Color.decode("#3a6529");
            case 49:
                return Color.decode("#497135");
            case 50:
                return Color.decode("#487532");
            case 51:
                return Color.decode("#3f652d");
            case 52:
                return Color.decode("#4e6d30");
            case 53:
                return Color.decode("#4e6d30");
            case 54:
                return Color.decode("#375a25");
            case 55:
                return Color.decode("#447131");
            case 56:
                return Color.decode("#3f652d");
            case 57:
                return Color.decode("#335622");
            case 58:
                return Color.decode("#335622");
            case 59:
                return Color.decode("#375a25");
            case 60:
                return Color.decode("#375a25");
            case 61:
                return Color.decode("#3f652d");
            case 62:
                return Color.decode("#375a25");
            case 63:
                return Color.decode("#42672f");
            case 64:
                return Color.decode("#395e27");
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
        List<Color> line1 = new ArrayList<>();
        for (int j = 1; j <= 8; j++) {
            line1.add(getColor(8 * i + j));
        }
        return line1;
    }

    /**
     * draw one creeper on the drawSurface.
     *
     * @param d the drawSurface
     * @param x the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneZombie(DrawSurface d, int x, int y) {
        for (int i = 0; i < 8; i++) {
            List<Color> line = getLinesColorList(i);
            for (int j = 0; j < line.size(); j++) {
                Color color = line.get(j);
                drawBigPixel(d, color, x + j * sizeOfPixel, y + sizeOfPixel * i);
            }
            line.clear();
        }
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, sizeOfPixel * 8, sizeOfPixel * 8);
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                drawOneZombie(d, i * sizeOfPixel * 8, j * sizeOfPixel * 8);
            }
        }
    }

    @Override
    public void timePassed() {

    }
}
