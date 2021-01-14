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
public class Creeper implements Sprite {
    private final int sizeOfPixel = 20;

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
                return new Color(27, 158, 20);
            case 2:
                return new Color(151, 207, 142);
            case 3:
                return new Color(74, 174, 62);
            case 4:
                return new Color(144, 202, 141);
            case 5:
                return new Color(192, 219, 184);
            case 6:
                return new Color(127, 219, 110);
            case 7:
                return new Color(116, 203, 99);
            case 8:
                return new Color(70, 145, 62);
            case 9:
                return new Color(93, 192, 84);
            case 10:
                return new Color(40, 142, 32);
            case 11:
                return new Color(68, 173, 54);
            case 12:
                return new Color(107, 198, 95);
            case 13:
                return new Color(110, 214, 93);
            case 14:
                return new Color(94, 186, 79);
            case 15:
                return new Color(191, 221, 187);
            case 16:
                return new Color(139, 213, 128);
            case 17:
                return new Color(70, 158, 56);
            case 18:
                return new Color(77, 154, 72);
            case 19:
                return new Color(200, 227, 194);
            case 20:
                return new Color(99, 199, 83);
            case 21:
                return new Color(79, 196, 74);
            case 22:
                return new Color(79, 196, 64);
            case 23:
                return new Color(94, 178, 80);
            case 24:
                return new Color(132, 208, 120);
            case 25:
                return new Color(138, 212, 127);
            case 26:
                return new Color(180, 217, 173);
            case 27:
                return new Color(65, 140, 58);
            case 28:
                return new Color(91, 203, 75);
            case 29:
                return new Color(72, 147, 65);
            case 30:
                return new Color(150, 209, 141);
            case 31:
                return new Color(100, 206, 82);
            case 32:
                return new Color(172, 216, 165);
            case 33:
                return new Color(94, 162, 89);
            case 34:
                return new Color(180, 230, 169);
            case 35:
                return new Color(75, 153, 67);
            case 36:
                return new Color(125, 219, 109);
            case 37:
                return new Color(138, 210, 124);
            case 38:
                return new Color(161, 213, 150);
            case 39:
                return new Color(51, 138, 43);
            case 40:
                return new Color(172, 227, 162);
            case 41:
                return new Color(89, 177, 73);
            case 42:
                return new Color(14, 153, 8);
            case 43:
                return new Color(62, 174, 50);
            case 44:
                return new Color(125, 208, 116);
            case 45:
                return new Color(59, 144, 53);
            case 46:
                return new Color(21, 159, 27);
            case 47:
                return new Color(94, 195, 77);
            case 48:
                return new Color(66, 174, 52);
            case 49:
                return new Color(154, 221, 144);
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
        switch (i) {
            case 1:
                line1.add(getColor(1));
                line1.add(getColor(2));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(4));
                line1.add(getColor(5));
                line1.add(getColor(6));
                line1.add(getColor(7));
                line1.add(getColor(8));
                line1.add(getColor(2));
                return line1;
            case 2:
                line1.add(getColor(9));
                line1.add(getColor(10));
                line1.add(getColor(9));
                line1.add(getColor(11));
                line1.add(getColor(12));
                line1.add(getColor(8));
                line1.add(getColor(13));
                line1.add(getColor(14));
                line1.add(getColor(15));
                line1.add(getColor(10));
                return line1;
            case 3:
                line1.add(getColor(16));
                line1.add(getColor(17));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(16));
                line1.add(getColor(18));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(19));
                line1.add(getColor(17));
                return line1;
            case 4:
                line1.add(getColor(20));
                line1.add(getColor(21));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(20));
                line1.add(getColor(11));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(7));
                line1.add(getColor(22));
                return line1;
            case 5:
                line1.add(getColor(23));
                line1.add(getColor(24));
                line1.add(getColor(23));
                line1.add(getColor(25));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(26));
                line1.add(getColor(27));
                line1.add(getColor(28));
                line1.add(getColor(24));
                return line1;
            case 6:
                line1.add(getColor(29));
                line1.add(getColor(30));
                line1.add(getColor(29));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(31));
                line1.add(getColor(32));
                line1.add(getColor(30));
                return line1;
            case 7:
                line1.add(getColor(33));
                line1.add(getColor(34));
                line1.add(getColor(33));
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(Color.BLACK);
                line1.add(getColor(14));
                line1.add(getColor(35));
                line1.add(getColor(34));
                return line1;
            case 8:
                line1.add(getColor(36));
                line1.add(getColor(20));
                line1.add(getColor(36));
                line1.add(Color.BLACK);
                line1.add(getColor(37));
                line1.add(getColor(38));
                line1.add(Color.BLACK);
                line1.add(getColor(39));
                line1.add(getColor(31));
                line1.add(getColor(20));
                return line1;
            case 9:
                line1.add(getColor(40));
                line1.add(getColor(41));
                line1.add(getColor(40));
                line1.add(getColor(31));
                line1.add(getColor(42));
                line1.add(getColor(43));
                line1.add(getColor(28));
                line1.add(getColor(22));
                line1.add(getColor(44));
                line1.add(getColor(41));
                return line1;
            case 10:
                line1.add(getColor(16));
                line1.add(getColor(9));
                line1.add(getColor(16));
                line1.add(getColor(45));
                line1.add(getColor(42));
                line1.add(getColor(46));
                line1.add(getColor(47));
                line1.add(getColor(48));
                line1.add(getColor(49));
                line1.add(getColor(9));
                return line1;
            default:
                return null;
        }
    }

    /**
     * draw one creeper on the drawSurface.
     *
     * @param d the drawSurface
     * @param x the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneCrepper(DrawSurface d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            List<Color> line1 = getLinesColorList(i + 1);
            for (int j = 0; j < line1.size(); j++) {
                Color color = line1.get(j);
                drawBigPixel(d, color, x + j * sizeOfPixel, y + sizeOfPixel * i);
            }
            line1.clear();
        }
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, sizeOfPixel * 10, sizeOfPixel * 10);
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                drawOneCrepper(d, i * sizeOfPixel * 8, j * sizeOfPixel * 8);
            }
        }
    }

    @Override
    public void timePassed() {

    }
}
